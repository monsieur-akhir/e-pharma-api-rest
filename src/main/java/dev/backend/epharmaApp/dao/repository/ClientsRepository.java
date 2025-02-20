package dev.backend.epharmaApp.dao.repository;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.backend.epharmaApp.utils.*;
import dev.backend.epharmaApp.utils.dto.*;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.customize._ClientsRepository;

/**
 * Repository : Clients.
 */
@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer>, _ClientsRepository {
	/**
	 * Finds Clients by using clientId as a search criteria.
	 * 
	 * @param clientId
	 * @return An Object Clients whose clientId is equals to the given clientId. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.clientId = :clientId and e.isDeleted = :isDeleted")
	Clients findOne(@Param("clientId")Integer clientId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Clients by using loginClient as a search criteria.
	 * 
	 * @param loginClient
	 * @return An Object Clients whose loginClient is equals to the given loginClient. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.loginClient = :loginClient and e.isDeleted = :isDeleted")
	List<Clients> findByLoginClient(@Param("loginClient")String loginClient, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using firstName as a search criteria.
	 * 
	 * @param firstName
	 * @return An Object Clients whose firstName is equals to the given firstName. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.firstName = :firstName and e.isDeleted = :isDeleted")
	List<Clients> findByFirstName(@Param("firstName")String firstName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using lastName as a search criteria.
	 * 
	 * @param lastName
	 * @return An Object Clients whose lastName is equals to the given lastName. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.lastName = :lastName and e.isDeleted = :isDeleted")
	List<Clients> findByLastName(@Param("lastName")String lastName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using email as a search criteria.
	 * 
	 * @param email
	 * @return An Object Clients whose email is equals to the given email. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.email = :email and e.isDeleted = :isDeleted")
	Clients findByEmail(@Param("email")String email, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using phone as a search criteria.
	 * 
	 * @param phone
	 * @return An Object Clients whose phone is equals to the given phone. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.phone = :phone and e.isDeleted = :isDeleted")
	List<Clients> findByPhone(@Param("phone")String phone, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using address as a search criteria.
	 * 
	 * @param address
	 * @return An Object Clients whose address is equals to the given address. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.address = :address and e.isDeleted = :isDeleted")
	List<Clients> findByAddress(@Param("address")String address, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using city as a search criteria.
	 * 
	 * @param city
	 * @return An Object Clients whose city is equals to the given city. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.city = :city and e.isDeleted = :isDeleted")
	List<Clients> findByCity(@Param("city")String city, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using location as a search criteria.
	 * 
	 * @param location
	 * @return An Object Clients whose location is equals to the given location. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.location = :location and e.isDeleted = :isDeleted")
	List<Clients> findByLocation(@Param("location")byte[] location, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using birthday as a search criteria.
	 * 
	 * @param birthday
	 * @return An Object Clients whose birthday is equals to the given birthday. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.birthday = :birthday and e.isDeleted = :isDeleted")
	List<Clients> findByBirthday(@Param("birthday")Date birthday, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using photo as a search criteria.
	 * 
	 * @param photo
	 * @return An Object Clients whose photo is equals to the given photo. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.photo = :photo and e.isDeleted = :isDeleted")
	List<Clients> findByPhoto(@Param("photo")String photo, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Clients whose recordStatus is equals to the given recordStatus. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Clients> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Clients whose createdAt is equals to the given createdAt. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Clients> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Clients whose createdBy is equals to the given createdBy. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Clients> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Clients whose updatedAt is equals to the given updatedAt. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Clients> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Clients whose updatedBy is equals to the given updatedBy. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Clients> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Clients whose isDeleted is equals to the given isDeleted. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.isDeleted = :isDeleted")
	List<Clients> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Clients whose deletedAt is equals to the given deletedAt. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Clients> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Clients by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Clients whose deletedBy is equals to the given deletedBy. If
	 *         no Clients is found, this method returns null.
	 */
	@Query("select e from Clients e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Clients> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Clients by using clientsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Clients
	 * @throws DataAccessException,ParseException
	 */
	default List<Clients> getByCriteria(Request<ClientsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Clients e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.clientId desc";
		TypedQuery<Clients> query = em.createQuery(req, Clients.class);
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
	 * Finds count of Clients by using clientsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Clients
	 * 
	 */
	default Long count(Request<ClientsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Clients e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.clientId desc";
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
	default String getWhereExpression(Request<ClientsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ClientsDto dto = request.getData() != null ? request.getData() : new ClientsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ClientsDto elt : request.getDatas()) {
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
	default String generateCriteria(ClientsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getClientId()!= null && dto.getClientId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("clientId", dto.getClientId(), "e.clientId", "Integer", dto.getClientIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLoginClient())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("loginClient", dto.getLoginClient(), "e.loginClient", "String", dto.getLoginClientParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFirstName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("firstName", dto.getFirstName(), "e.firstName", "String", dto.getFirstNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLastName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("lastName", dto.getLastName(), "e.lastName", "String", dto.getLastNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getEmail())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("email", dto.getEmail(), "e.email", "String", dto.getEmailParam(), param, index, locale));
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
			if (dto.getLocation()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("location", dto.getLocation(), "e.location", "byte[]", dto.getLocationParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getBirthday())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("birthday", dto.getBirthday(), "e.birthday", "Date", dto.getBirthdayParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPhoto())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("photo", dto.getPhoto(), "e.photo", "String", dto.getPhotoParam(), param, index, locale));
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
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
