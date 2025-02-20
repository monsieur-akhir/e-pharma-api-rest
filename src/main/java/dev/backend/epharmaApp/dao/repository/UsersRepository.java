package dev.backend.epharmaApp.dao.repository;

import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.repository.customize._UsersRepository;
import dev.backend.epharmaApp.utils.CriteriaUtils;
import dev.backend.epharmaApp.utils.Utilities;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.dto.UsersDto;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.util.*;

/**
 * Repository : Users.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>, _UsersRepository {
	/**
	 * Finds Users by using userId as a search criteria.
	 * 
	 * @param userId
	 * @return An Object Users whose userId is equals to the given userId. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.userId = :userId and e.isDeleted = :isDeleted")
	Users findOne(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Users by using login as a search criteria.
	 * 
	 * @param login
	 * @return An Object Users whose login is equals to the given login. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.login = :login and e.isDeleted = :isDeleted")
	Users findByLogin(@Param("login")String login, @Param("isDeleted")Boolean isDeleted);

	@Query("select e from Users e where e.login = :login and e.isDeleted = :isDeleted")
	List<Users> findByLoginList(@Param("login")String login, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using email as a search criteria.
	 * 
	 * @param email
	 * @return An Object Users whose email is equals to the given email. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.email = :email and e.isDeleted = :isDeleted")
	Users findByEmail(@Param("email")String email, @Param("isDeleted")Boolean isDeleted);

	@Query("select e from Users e where e.email = :email and e.isDeleted = :isDeleted")
	List <Users>  findByEmail1(@Param("email")String email, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using firstName as a search criteria.
	 * 
	 * @param firstName
	 * @return An Object Users whose firstName is equals to the given firstName. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.firstName = :firstName and e.isDeleted = :isDeleted")
	List<Users> findByFirstName(@Param("firstName")String firstName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using lastName as a search criteria.
	 * 
	 * @param lastName
	 * @return An Object Users whose lastName is equals to the given lastName. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.lastName = :lastName and e.isDeleted = :isDeleted")
	List<Users> findByLastName(@Param("lastName")String lastName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using passwordHash as a search criteria.
	 * 
	 * @param passwordHash
	 * @return An Object Users whose passwordHash is equals to the given passwordHash. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.passwordHash = :passwordHash and e.isDeleted = :isDeleted")
	List<Users> findByPasswordHash(@Param("passwordHash")String passwordHash, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using phone as a search criteria.
	 * 
	 * @param phone
	 * @return An Object Users whose phone is equals to the given phone. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.phone = :phone and e.isDeleted = :isDeleted")
	List<Users> findByPhone(@Param("phone")String phone, @Param("isDeleted")Boolean isDeleted);

	@Query("select e from Users e where e.phone = :phone and e.isDeleted = :isDeleted")
	List<Users> findByPhone1(@Param("phone")String phone, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using address as a search criteria.
	 * 
	 * @param address
	 * @return An Object Users whose address is equals to the given address. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.address = :address and e.isDeleted = :isDeleted")
	List<Users> findByAddress(@Param("address")String address, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using city as a search criteria.
	 * 
	 * @param city
	 * @return An Object Users whose city is equals to the given city. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.city = :city and e.isDeleted = :isDeleted")
	List<Users> findByCity(@Param("city")String city, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using country as a search criteria.
	 * 
	 * @param country
	 * @return An Object Users whose country is equals to the given country. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.country = :country and e.isDeleted = :isDeleted")
	List<Users> findByCountry(@Param("country")String country, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Users whose recordStatus is equals to the given recordStatus. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Users> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Users whose createdAt is equals to the given createdAt. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Users> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Users whose createdBy is equals to the given createdBy. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Users> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Users whose updatedAt is equals to the given updatedAt. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Users> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Users whose updatedBy is equals to the given updatedBy. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Users> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Users whose isDeleted is equals to the given isDeleted. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.isDeleted = :isDeleted")
	List<Users> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Users whose deletedAt is equals to the given deletedAt. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Users> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Users by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Users whose deletedBy is equals to the given deletedBy. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Users> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Users by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object Users whose pharmacyId is equals to the given pharmacyId. If
	 *         no Users is found, this method returns null.
	 */
	@Query("select e from Users e where e.pharmacies.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	List<Users> findByPharmacyId(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Users by using usersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Users
	 * @throws DataAccessException,ParseException
	 */
	default List<Users> getByCriteria(Request<UsersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Users e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.userId desc";
		TypedQuery<Users> query = em.createQuery(req, Users.class);
		for (Map.Entry<String, java.lang.Object> entry : param.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		if (request.getIndex() != null && request.getSize() != null) {
			query.setFirstResult(request.getIndex() * request.getSize());
			query.setMaxResults(request.getSize());
		}
		return query.getResultList();
	}

	/**
	 * Finds count of Users by using usersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Users
	 * 
	 */
	default Long count(Request<UsersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Users e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.userId desc";
		javax.persistence.Query query = em.createQuery(req);
		for (Map.Entry<String, java.lang.Object> entry : param.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		Long count = (Long) query.getResultList().get(0);
		return count;
	}

	/**
	 * get where expression
	 * @param request
	 * @param param
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	default String getWhereExpression(Request<UsersDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		UsersDto dto = request.getData() != null ? request.getData() : new UsersDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (UsersDto elt : request.getDatas()) {
				elt.setIsDeleted(false);
				String eltReq = generateCriteria(elt, param, index, locale);
				if (request.getIsAnd() != null && request.getIsAnd()) {
					othersReq += "and (" + eltReq + ") ";
				} else {
					othersReq += "or (" + eltReq + ") ";
				}
				index++;
			}
		}
		String req = "";
		if (!mainReq.isEmpty()) {
			req += " and (" + mainReq + ") ";
		}
		req += othersReq;
		return req;
	}

	/**
	 * generate sql query for dto
	 * @param dto
	 * @param param
	 * @param index
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	default String generateCriteria(UsersDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getUserId()!= null && dto.getUserId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("userId", dto.getUserId(), "e.userId", "Integer", dto.getUserIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLogin())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("login", dto.getLogin(), "e.login", "String", dto.getLoginParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getEmail())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("email", dto.getEmail(), "e.email", "String", dto.getEmailParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFirstName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("firstName", dto.getFirstName(), "e.firstName", "String", dto.getFirstNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLastName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("lastName", dto.getLastName(), "e.lastName", "String", dto.getLastNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPasswordHash())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("passwordHash", dto.getPasswordHash(), "e.passwordHash", "String", dto.getPasswordHashParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPhone())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("phone", dto.getPhone(), "e.phone", "String", dto.getPhoneParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getAddress())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("address", dto.getAddress(), "e.address", "String", dto.getAddressParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCity())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("city", dto.getCity(), "e.city", "String", dto.getCityParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCountry())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("country", dto.getCountry(), "e.country", "String", dto.getCountryParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getRecordStatus())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("recordStatus", dto.getRecordStatus(), "e.recordStatus", "String", dto.getRecordStatusParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCreatedAt())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
			}
			if (dto.getCreatedBy()!= null && dto.getCreatedBy() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("createdBy", dto.getCreatedBy(), "e.createdBy", "Integer", dto.getCreatedByParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUpdatedAt())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("updatedAt", dto.getUpdatedAt(), "e.updatedAt", "Date", dto.getUpdatedAtParam(), param, index, locale));
			}
			if (dto.getUpdatedBy()!= null && dto.getUpdatedBy() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("updatedBy", dto.getUpdatedBy(), "e.updatedBy", "Integer", dto.getUpdatedByParam(), param, index, locale));
			}
			if (dto.getIsDeleted()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("isDeleted", dto.getIsDeleted(), "e.isDeleted", "Boolean", dto.getIsDeletedParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDeletedAt())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("deletedAt", dto.getDeletedAt(), "e.deletedAt", "Date", dto.getDeletedAtParam(), param, index, locale));
			}
			if (dto.getDeletedBy()!= null && dto.getDeletedBy() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("deletedBy", dto.getDeletedBy(), "e.deletedBy", "Integer", dto.getDeletedByParam(), param, index, locale));
			}
			if (dto.getPharmacyId()!= null && dto.getPharmacyId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("pharmacyId", dto.getPharmacyId(), "e.pharmacies.pharmacyId", "Integer", dto.getPharmacyIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
