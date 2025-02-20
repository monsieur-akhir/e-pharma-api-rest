package dev.backend.epharmaApp.dao.repository;

import dev.backend.epharmaApp.dao.entity.DeliveryPersonProfiles;
import dev.backend.epharmaApp.dao.repository.customize._DeliveryPersonProfilesRepository;
import dev.backend.epharmaApp.utils.CriteriaUtils;
import dev.backend.epharmaApp.utils.Utilities;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.dto.DeliveryPersonProfilesDto;
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
 * Repository : DeliveryPersonProfiles.
 */
@Repository
public interface DeliveryPersonProfilesRepository extends JpaRepository<DeliveryPersonProfiles, Integer>, _DeliveryPersonProfilesRepository {
	/**
	 * Finds DeliveryPersonProfiles by using userId as a search criteria.
	 * 
	 * @param userId
	 * @return An Object DeliveryPersonProfiles whose userId is equals to the given userId. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.users.userId = :userId and e.isDeleted = :isDeleted")
	DeliveryPersonProfiles findOne(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds DeliveryPersonProfiles by using status as a search criteria.
	 * 
	 * @param status
	 * @return An Object DeliveryPersonProfiles whose status is equals to the given status. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.status = :status and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByStatus(@Param("status")String status, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using registeredDate as a search criteria.
	 * 
	 * @param registeredDate
	 * @return An Object DeliveryPersonProfiles whose registeredDate is equals to the given registeredDate. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.registeredDate = :registeredDate and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByRegisteredDate(@Param("registeredDate")Date registeredDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object DeliveryPersonProfiles whose recordStatus is equals to the given recordStatus. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object DeliveryPersonProfiles whose createdAt is equals to the given createdAt. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object DeliveryPersonProfiles whose createdBy is equals to the given createdBy. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object DeliveryPersonProfiles whose updatedAt is equals to the given updatedAt. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object DeliveryPersonProfiles whose updatedBy is equals to the given updatedBy. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object DeliveryPersonProfiles whose isDeleted is equals to the given isDeleted. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object DeliveryPersonProfiles whose deletedAt is equals to the given deletedAt. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds DeliveryPersonProfiles by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object DeliveryPersonProfiles whose deletedBy is equals to the given deletedBy. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds DeliveryPersonProfiles by using userId as a search criteria.
	 * 
	 * @param userId
	 * @return An Object DeliveryPersonProfiles whose userId is equals to the given userId. If
	 *         no DeliveryPersonProfiles is found, this method returns null.
	 */
	@Query("select e from DeliveryPersonProfiles e where e.users.userId = :userId and e.isDeleted = :isDeleted")
	List<DeliveryPersonProfiles> findByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of DeliveryPersonProfiles by using deliveryPersonProfilesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of DeliveryPersonProfiles
	 * @throws DataAccessException,ParseException
	 */
	default List<DeliveryPersonProfiles> getByCriteria(Request<DeliveryPersonProfilesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from DeliveryPersonProfiles e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.userId desc";
		TypedQuery<DeliveryPersonProfiles> query = em.createQuery(req, DeliveryPersonProfiles.class);
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
	 * Finds count of DeliveryPersonProfiles by using deliveryPersonProfilesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of DeliveryPersonProfiles
	 * 
	 */
	default Long count(Request<DeliveryPersonProfilesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from DeliveryPersonProfiles e where e IS NOT NULL";
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
	default String getWhereExpression(Request<DeliveryPersonProfilesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		DeliveryPersonProfilesDto dto = request.getData() != null ? request.getData() : new DeliveryPersonProfilesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (DeliveryPersonProfilesDto elt : request.getDatas()) {
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
	default String generateCriteria(DeliveryPersonProfilesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (Utilities.notBlank(dto.getStatus())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("status", dto.getStatus(), "e.status", "String", dto.getStatusParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getRegisteredDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("registeredDate", dto.getRegisteredDate(), "e.registeredDate", "Date", dto.getRegisteredDateParam(), param, index, locale));
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
			if (dto.getUserId()!= null && dto.getUserId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("userId", dto.getUserId(), "e.users.userId", "Integer", dto.getUserIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersLogin())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersLogin", dto.getUsersLogin(), "e.users.login", "String", dto.getUsersLoginParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersFirstName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersFirstName", dto.getUsersFirstName(), "e.users.firstName", "String", dto.getUsersFirstNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersLastName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersLastName", dto.getUsersLastName(), "e.users.lastName", "String", dto.getUsersLastNameParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
