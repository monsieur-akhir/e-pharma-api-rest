package dev.backend.epharmaApp.business;

import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.repository.OrdersRepository;
import dev.backend.epharmaApp.dao.repository.PharmaciesRepository;
import dev.backend.epharmaApp.dao.repository.RolesRepository;
import dev.backend.epharmaApp.dao.repository.UsersRepository;
import dev.backend.epharmaApp.utils.*;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.contract.Response;
import dev.backend.epharmaApp.utils.dto.LoginDto;
import dev.backend.epharmaApp.utils.dto.RefreshTokenDto;
import dev.backend.epharmaApp.utils.dto.UsersDto;
import dev.backend.epharmaApp.utils.dto.transformer.UsersTransformer;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Log
@Component
public class AuthBusiness {
    private Response<UsersDto> response;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository roleRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PharmaciesRepository pharmaciesRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private FunctionalError functionalError;
    @Autowired
    private PasswordEncoder passwordEncoder; // Injection du PasswordEncoder pour crypter les mots de passe
    @Autowired
    private TechnicalError technicalError;
    @Autowired
    private ExceptionUtils exceptionUtils;
    @PersistenceContext
    private EntityManager em;

    private SimpleDateFormat dateFormat;
    private SimpleDateFormat dateTimeFormat;

    public AuthBusiness() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public Response<UsersDto> registerTraveller(Request<UsersDto> request, Locale locale) throws ParseException {
        log.info("----begin register Traveller-----");

        Response<UsersDto> response = new Response<>();
        List<Users> usersToSave = new ArrayList<>();

        for (UsersDto dto : request.getDatas()) {
            // Vérification des paramètres obligatoires
            Map<String, Object> fieldsToVerify = new HashMap<>();
            fieldsToVerify.put("login", dto.getLogin());
            fieldsToVerify.put("phone", dto.getPhone());
            fieldsToVerify.put("password", dto.getPasswordHash());

            if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
                response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
                response.setHasError(true);
                return response;
            }

            // Vérification si le voyageur existe déjà par email
            List<Users> existingUsersByEmail = usersRepository.findByEmail1(dto.getEmail(), false);
            if (!existingUsersByEmail.isEmpty()) {
                response.setStatus(functionalError.DATA_EXIST("Users email -> " + dto.getEmail(), locale));
                response.setHasError(true);
                return response;
            }
// Vérification des doublons dans les données à sauvegarder (email)
            if (usersToSave.stream().anyMatch(a -> a.getEmail().equalsIgnoreCase(dto.getEmail()))) {
                response.setStatus(functionalError.DATA_DUPLICATE("email", locale));
                response.setHasError(true);
                return response;
            }

// Vérification si le voyageur existe déjà par numéro de téléphone
            List<Users> existingUsersByPhone = usersRepository.findByPhone1(dto.getPhone(), false);
            if (!existingUsersByPhone.isEmpty()) {
                response.setStatus(functionalError.DATA_EXIST("Users phone -> " + dto.getPhone(), locale));
                response.setHasError(true);
                return response;
            }

// Vérification des doublons dans les données à sauvegarder (téléphone)
            if (usersToSave.stream().anyMatch(a -> a.getPhone().equalsIgnoreCase(dto.getPhone()))) {
                response.setStatus(functionalError.DATA_DUPLICATE("phone", locale));
                response.setHasError(true);
                return response;
            }



            // Affectation du rôle "Voyageur"
            if (dto.getRoleId() == null) {
                dto.setRoleId(roleRepository.findByName("CLIENT", false).getRoleId());
            }

            // Vérification du rôle
            Roles existingRole = roleRepository.findOne(dto.getRoleId(), false);
            if (existingRole == null) {
                response.setStatus(functionalError.DATA_NOT_EXIST("Role roleId -> " + dto.getRoleId(), locale));
                response.setHasError(true);
                return response;
            }

            //affectation de status
            if (dto.getRecordStatus() == null) {
                dto.setRecordStatus("ACTIVE");
            }

            // verification de la pharmacie
            Pharmacies existingPharmacies = null;
            if (dto.getPharmacyId() != null && dto.getPharmacyId() > 0) {
                existingPharmacies = pharmaciesRepository.findOne(dto.getPharmacyId(), false);
                if (existingPharmacies == null) {
                    response.setStatus(functionalError.DATA_NOT_EXIST("pharmacies pharmacyId -> " + dto.getPharmacyId(), locale));
                    response.setHasError(true);
                    return response;
                }
            }

            // Transformation du DTO en entité
            Users userToSave = UsersTransformer.INSTANCE.toEntity(dto, existingPharmacies);

            // 🔐 Crypter le mot de passe avant la sauvegarde
            String encryptedPassword = passwordEncoder.encode(dto.getPasswordHash());
            userToSave.setPasswordHash(encryptedPassword);

            userToSave.setCreatedAt(Utilities.getCurrentDate());
            userToSave.setCreatedBy(request.getUser());
            userToSave.setIsClient(true);
            userToSave.setIsDeleted(false);

            usersToSave.add(userToSave);
        }

        // Sauvegarde des utilisateurs en base
        if (!usersToSave.isEmpty()) {
            List<Users> savedUsers = usersRepository.saveAll(usersToSave);

            if (savedUsers == null) {
                response.setStatus(functionalError.SAVE_FAIL("Users", locale));
                response.setHasError(true);
                return response;
            }

            List<UsersDto> usersDto = Utilities.isTrue(request.getIsSimpleLoading())
                    ? UsersTransformer.INSTANCE.toLiteDtos(savedUsers)
                    : UsersTransformer.INSTANCE.toDtos(savedUsers);

            response.setItems(usersDto);
            response.setHasError(false);
        }

        log.info("----end register Traveller-----");
        return response;
    }
    public Response<UsersDto> login(Request<LoginDto> request, Locale locale) throws ParseException {
        log.info("----begin login Users-----");

        Response<UsersDto> response = new Response<>();

        if (request == null || request.getData() == null) {
            response.setStatus(functionalError.DATA_NOT_EXIST("Login data", locale));
            response.setHasError(true);
            return response;
        }

        LoginDto loginDto = request.getData();

        // Vérification des champs obligatoires
        Map<String, Object> fieldsToVerify = new HashMap<>();
        fieldsToVerify.put("emailOrPhone", loginDto.getEmailOrPhone());
        fieldsToVerify.put("password", loginDto.getPassword());

        if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
            response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
            response.setHasError(true);
            return response;
        }

        // Rechercher l'utilisateur par email ou téléphone
        Users user = usersRepository.findByEmailOrPhone(loginDto.getEmailOrPhone());

        if (user == null) {
            response.setStatus(functionalError.DATA_NOT_EXIST("Users", locale));
            response.setHasError(true);
            return response;
        }

        // Vérifier le mot de passe
        if (!Utilities.matchPassword(loginDto.getPassword(), user.getPasswordHash())) {
            response.setStatus(functionalError.INVALID_VALUE("Password", locale));
            response.setHasError(true);
            return response;
        }

        // Générer les tokens
        String accessToken = tokenService.generateAccessToken(user);
        String refreshToken = tokenService.generateRefreshToken(user);

        // Vérifier s'il y a déjà un refresh token en Redis
        String existingRefreshToken = tokenService.getRefreshTokenFromRedis(Long.valueOf(user.getUserId()));
        if (existingRefreshToken != null) {
            // Invalider l'ancien refresh token en le supprimant de Redis
            tokenService.removeTokensFromRedis(Long.valueOf(user.getUserId()));
        }

        // Sauvegarde des nouveaux tokens dans Redis
        tokenService.storeTokensInRedis(Long.valueOf(user.getUserId()), accessToken, refreshToken);

        // Retourner les détails de l'utilisateur connecté
        UsersDto usersDto = UsersTransformer.INSTANCE.toDto(user);
        usersDto.setToken(accessToken);
        usersDto.setRefreshToken(refreshToken);

        response.setItem(usersDto);
        response.setHasError(false);

        log.info("----end login Users-----");
        return response;
    }

    public Response<UsersDto> refreshAccessToken(Request<RefreshTokenDto> request, Locale locale) throws ParseException {
        log.info("----begin refreshAccessToken-----");

        Response<UsersDto> response = new Response<>();

        if (request == null || request.getData() == null) {
            response.setStatus(functionalError.DATA_NOT_EXIST("Refresh token data", locale));
            response.setHasError(true);
            return response;
        }

        RefreshTokenDto refreshTokenDto = request.getData();

        // Rechercher le refresh token dans Redis
        String storedRefreshToken = tokenService.getRefreshTokenFromRedis(refreshTokenDto.getUserId());

        if (storedRefreshToken == null || !storedRefreshToken.equals(refreshTokenDto.getRefreshToken())) {
            response.setStatus(functionalError.INVALID_VALUE("Refresh Token", locale));
            response.setHasError(true);
            return response;
        }

        // Générer un nouveau token d'accès
        Users user = usersRepository.findById(Math.toIntExact(refreshTokenDto.getUserId())).orElse(null);

        if (user == null) {
            response.setStatus(functionalError.DATA_NOT_EXIST("Users", locale));
            response.setHasError(true);
            return response;
        }

        String newAccessToken = tokenService.generateAccessToken(user);
        String newRefreshToken = tokenService.generateRefreshToken(user);

        // Mise à jour des tokens dans Redis
        tokenService.storeTokensInRedis(refreshTokenDto.getUserId(), newAccessToken, newRefreshToken);

        // Retourner le nouveau token
        UsersDto usersDto = UsersTransformer.INSTANCE.toDto(user);
        usersDto.setToken(newAccessToken);
        usersDto.setRefreshToken(newRefreshToken);

        response.setItem(usersDto);
        response.setHasError(false);

        log.info("----end refreshAccessToken-----");
        return response;
    }

    private UsersDto getFullInfos(UsersDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
        // put code here

        if (Utilities.isTrue(isSimpleLoading)) {
            return dto;
        }
        if (size > 1) {
            return dto;
        }

        return dto;
    }

    @SuppressWarnings("unused")
    /**
     * Déconnexion de l'utilisateur.
     */
    public Response<UsersDto> logOut(Request<UsersDto> request, Locale locale) {
        log.info("---- Begin logOut ----");
        Response<UsersDto> response = new Response<>();

        try {
            // Vérification des paramètres obligatoires
            if (request == null || request.getData() == null || request.getData().getUserId() == null) {
                response.setStatus(functionalError.FIELD_EMPTY("id", locale));
                response.setHasError(true);
                return response;
            }

            Integer userId = request.getData().getUserId();

            // Vérification si l'utilisateur existe en base
            Users existingUser = usersRepository.findOne(userId, false);
            if (existingUser == null) {
                response.setStatus(functionalError.DATA_NOT_EXIST("User ID -> " + userId, locale));
                response.setHasError(true);
                return response;
            }

            // Vérification si l'utilisateur est connecté
            boolean isUserConnected = tokenService.isUserConnected(Long.valueOf(userId));
            if (!isUserConnected) {
                response.setStatus(functionalError.DATA_NOT_EXIST("User is not connected.", locale));
                response.setHasError(true);
                return response;
            }

            // Suppression des tokens dans Redis
            tokenService.removeTokensFromRedis(Long.valueOf(userId));
            log.info("Tokens for user ID: {} have been removed from Redis.");

            response.setStatus(functionalError.SUCCESS("Vous êtes déconnecté.", locale));
            response.setHasError(false);

        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                log.info("Erreur | Code: {} - Message: {}");
                throw new RuntimeException(response.getStatus().getCode() + "; " + response.getStatus().getMessage());
            }
        }

        response.setActionEffectue("Déconnexion de l'utilisateur");
        log.info("---- End logOut ----");
        return response;
    }


}
