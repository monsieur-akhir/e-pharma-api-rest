package dev.backend.epharmaApp.dao.repository;

import java.util.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
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
import dev.backend.epharmaApp.dao.repository.customize._UserRatingsRepository;

/**
 * Repository : UserRatings.
 */
@Repository
public interface UserRatingsRepository extends JpaRepository<UserRatings, Integer>, _UserRatingsRepository {
	/**
	 * Finds UserRatings by using ratingId as a search criteria.
	 * 
	 * @param ratingId
	 * @return An Object UserRatings whose ratingId is equals to the given ratingId. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.ratingId = :ratingId and e.isDeleted = :isDeleted")
	UserRatings findOne(@Param("ratingId")Integer ratingId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds UserRatings by using ratingValue as a search criteria.
	 * 
	 * @param ratingValue
	 * @return An Object UserRatings whose ratingValue is equals to the given ratingValue. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.ratingValue = :ratingValue and e.isDeleted = :isDeleted")
	List<UserRatings> findByRatingValue(@Param("ratingValue")Byte ratingValue, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using comment as a search criteria.
	 * 
	 * @param comment
	 * @return An Object UserRatings whose comment is equals to the given comment. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.comment = :comment and e.isDeleted = :isDeleted")
	List<UserRatings> findByComment(@Param("comment")String comment, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object UserRatings whose recordStatus is equals to the given recordStatus. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<UserRatings> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object UserRatings whose createdAt is equals to the given createdAt. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<UserRatings> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object UserRatings whose createdBy is equals to the given createdBy. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<UserRatings> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object UserRatings whose updatedAt is equals to the given updatedAt. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<UserRatings> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object UserRatings whose updatedBy is equals to the given updatedBy. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<UserRatings> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object UserRatings whose isDeleted is equals to the given isDeleted. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.isDeleted = :isDeleted")
	List<UserRatings> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object UserRatings whose deletedAt is equals to the given deletedAt. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<UserRatings> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds UserRatings by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object UserRatings whose deletedBy is equals to the given deletedBy. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<UserRatings> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds UserRatings by using ratedUserId as a search criteria.
	 * 
	 * @param ratedUserId
	 * @return An Object UserRatings whose ratedUserId is equals to the given ratedUserId. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.users.userId = :ratedUserId and e.isDeleted = :isDeleted")
	List<UserRatings> findByRatedUserId(@Param("ratedUserId")Integer ratedUserId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds UserRatings by using raterId as a search criteria.
	 * 
	 * @param raterId
	 * @return An Object UserRatings whose raterId is equals to the given raterId. If
	 *         no UserRatings is found, this method returns null.
	 */
	@Query("select e from UserRatings e where e.users2.userId = :raterId and e.isDeleted = :isDeleted")
	List<UserRatings> findByRaterId(@Param("raterId")Integer raterId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of UserRatings by using userRatingsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of UserRatings
	 * @throws DataAccessException,ParseException
	 */
	default List<UserRatings> getByCriteria(Request<UserRatingsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from UserRatings e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.ratingId desc";
		TypedQuery<UserRatings> query = em.createQuery(req, UserRatings.class);
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
	 * Finds count of UserRatings by using userRatingsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of UserRatings
	 * 
	 */
	default Long count(Request<UserRatingsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from UserRatings e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.ratingId desc";
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
	default String getWhereExpression(Request<UserRatingsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		UserRatingsDto dto = request.getData() != null ? request.getData() : new UserRatingsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (UserRatingsDto elt : request.getDatas()) {
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
	default String generateCriteria(UserRatingsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getRatingId()!= null && dto.getRatingId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("ratingId", dto.getRatingId(), "e.ratingId", "Integer", dto.getRatingIdParam(), param, index, locale));
			}
			if (dto.getRatingValue()!= null && dto.getRatingValue() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("ratingValue", dto.getRatingValue(), "e.ratingValue", "Byte", dto.getRatingValueParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getComment())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("comment", dto.getComment(), "e.comment", "String", dto.getCommentParam(), param, index, locale));
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
			if (dto.getRatedUserId()!= null && dto.getRatedUserId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("ratedUserId", dto.getRatedUserId(), "e.users.userId", "Integer", dto.getRatedUserIdParam(), param, index, locale));
			}
			if (dto.getRaterId()!= null && dto.getRaterId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("raterId", dto.getRaterId(), "e.users2.userId", "Integer", dto.getRaterIdParam(), param, index, locale));
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
			if (Utilities.notBlank(dto.getUsersLogin())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersLogin", dto.getUsersLogin(), "e.users2.login", "String", dto.getUsersLoginParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersFirstName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersFirstName", dto.getUsersFirstName(), "e.users2.firstName", "String", dto.getUsersFirstNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersLastName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersLastName", dto.getUsersLastName(), "e.users2.lastName", "String", dto.getUsersLastNameParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
