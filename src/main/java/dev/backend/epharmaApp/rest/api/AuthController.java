package dev.backend.epharmaApp.rest.api;

import dev.backend.epharmaApp.business.AuthBusiness;
import dev.backend.epharmaApp.business.UsersBusiness;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.repository.UsersRepository;
import dev.backend.epharmaApp.utils.*;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.contract.Response;
import dev.backend.epharmaApp.utils.dto.LoginDto;
import dev.backend.epharmaApp.utils.dto.RefreshTokenDto;
import dev.backend.epharmaApp.utils.dto.UsersDto;
import dev.backend.epharmaApp.utils.dto.transformer.UsersTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsersBusiness usersBusiness;

    @Autowired
    private FunctionalError functionalError;

    @Autowired
    private AuthBusiness authBusiness;

    @Autowired
    private HttpServletRequest requestBasic;

    @Autowired
    private ExceptionUtils exceptionUtils;

    /**
     * Authentification de l'utilisateur et génération des tokens.
     */
    @PostMapping("/login")
    public Response<UsersDto> login(@RequestBody Request<LoginDto> request, Locale locale) throws ParseException {
        Response<UsersDto> response = new Response<>();

        if (request == null || request.getData() == null) {
            response.setStatus(functionalError.DATA_NOT_EXIST("Login data", locale));
            response.setHasError(true);
            return response;
        }

        LoginDto loginDto = request.getData();
        Users user = usersRepository.findByEmailOrPhone(loginDto.getEmailOrPhone());
        if (user == null) {
            response.setStatus(functionalError.DATA_NOT_EXIST("User", locale));
            response.setHasError(true);
            return response;
        }
        if (!Utilities.matchPassword(loginDto.getPassword(), user.getPasswordHash())) {
            response.setStatus(functionalError.INVALID_VALUE("Password", locale));
            response.setHasError(true);
            return response;
        }

        String accessToken = tokenService.generateAccessToken(user);
        String refreshToken = tokenService.generateRefreshToken(user);
        tokenService.storeTokensInRedis(Long.valueOf(user.getUserId()), accessToken, refreshToken);

        UsersDto usersDto = UsersTransformer.INSTANCE.toDto(user);
        usersDto.setToken(accessToken);
        usersDto.setRefreshToken(refreshToken);
        response.setItem(usersDto);
        response.setHasError(false);

        log.info("Utilisateur {} authentifié avec succès.", user.getUserId());
        return response;
    }

    /**
     * Renouvellement du token d'accès à l'aide du refresh token.
     */
    @PostMapping("/refresh-token")
    public Response<UsersDto> refreshAccessToken(@RequestBody RefreshTokenDto request, Locale locale) throws ParseException {
        Response<UsersDto> response = new Response<>();

        String storedRefreshToken = tokenService.getRefreshTokenFromRedis(request.getUserId());
        if (storedRefreshToken == null || !storedRefreshToken.equals(request.getRefreshToken())) {
            response.setStatus(functionalError.INVALID_VALUE("Refresh Token", locale));
            response.setHasError(true);
            return response;
        }

        Users user = usersRepository.findById(Math.toIntExact(request.getUserId())).orElse(null);
        if (user == null) {
            response.setStatus(functionalError.DATA_NOT_EXIST("User", locale));
            response.setHasError(true);
            return response;
        }

        String newAccessToken = tokenService.generateAccessToken(user);
        String newRefreshToken = tokenService.generateRefreshToken(user);
        tokenService.storeTokensInRedis(Long.valueOf(user.getUserId()), newAccessToken, newRefreshToken);

        UsersDto usersDto = UsersTransformer.INSTANCE.toDto(user);
        usersDto.setToken(newAccessToken);
        usersDto.setRefreshToken(newRefreshToken);
        response.setItem(usersDto);
        response.setHasError(false);

        log.info("Token renouvelé pour l'utilisateur {}.", user.getUserId());
        return response;
    }

    /**
     * Déconnexion de l'utilisateur.
     */
    @PostMapping("/logOut")
    public Response<UsersDto> logOut(@RequestBody Request<UsersDto> request) {
        log.info("Début de la méthode logOut");
        Response<UsersDto> response = new Response<>();
        String languageID = (String) requestBasic.getAttribute("CURRENT_LANGUAGE_IDENTIFIER");
        Locale locale = new Locale(languageID, "");
        try {
            response = Validate.validateObject(request, response, functionalError, locale);
            if (!response.isHasError()) {
                response = authBusiness.logOut(request, locale);
                if (!response.isHasError()) {
                    log.info("Déconnexion réussie pour l'utilisateur.");
                } else {
                    log.warn("Erreur lors de la déconnexion : code: {} - message: {}",
                            response.getStatus().getCode(), response.getStatus().getMessage());
                }
            } else {
                log.warn("Validation échouée lors de logOut : code: {} - message: {}",
                        response.getStatus().getCode(), response.getStatus().getMessage());
            }
        } catch (CannotCreateTransactionException e) {
            exceptionUtils.CANNOT_CREATE_TRANSACTION_EXCEPTION(response, locale, e);
        } catch (TransactionSystemException e) {
            exceptionUtils.TRANSACTION_SYSTEM_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        }
        log.info("Fin de la méthode logOut");
        return response;
    }

    /**
     * Inscription d'un nouvel utilisateur.
     */
    @PostMapping("/register")
    public Response<UsersDto> registerTraveller(@RequestBody Request<UsersDto> request, Locale locale) throws ParseException {
        return authBusiness.registerTraveller(request, locale);
    }
}
