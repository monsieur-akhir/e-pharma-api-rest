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
import dev.backend.epharmaApp.dao.entity.ChatRoomParticipantsKey;
import dev.backend.epharmaApp.dao.repository.customize._ChatRoomParticipantsRepository;

/**
 * Repository : ChatRoomParticipants.
 */
@Repository
public interface ChatRoomParticipantsRepository extends JpaRepository<ChatRoomParticipants, ChatRoomParticipantsKey>, _ChatRoomParticipantsRepository {
	/**
	 * Finds ChatRoomParticipants by using roomId as a search criteria.
	 * 
	 * @param roomId
	 * @return An Object ChatRoomParticipants whose roomId is equals to the given roomId. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.chatRooms.roomId = :roomId and e.isDeleted = :isDeleted")
	ChatRoomParticipants findOneByRoomId(@Param("roomId")Integer roomId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatRoomParticipants by using userId as a search criteria.
	 * 
	 * @param userId
	 * @return An Object ChatRoomParticipants whose userId is equals to the given userId. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.users.userId = :userId and e.isDeleted = :isDeleted")
	ChatRoomParticipants findOneByUsersId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatRoomParticipants by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object ChatRoomParticipants whose recordStatus is equals to the given recordStatus. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRoomParticipants by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object ChatRoomParticipants whose createdAt is equals to the given createdAt. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRoomParticipants by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object ChatRoomParticipants whose createdBy is equals to the given createdBy. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRoomParticipants by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object ChatRoomParticipants whose updatedAt is equals to the given updatedAt. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRoomParticipants by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object ChatRoomParticipants whose updatedBy is equals to the given updatedBy. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRoomParticipants by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object ChatRoomParticipants whose isDeleted is equals to the given isDeleted. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRoomParticipants by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object ChatRoomParticipants whose deletedAt is equals to the given deletedAt. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRoomParticipants by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object ChatRoomParticipants whose deletedBy is equals to the given deletedBy. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatRoomParticipants by using userId as a search criteria.
	 * 
	 * @param userId
	 * @return An Object ChatRoomParticipants whose userId is equals to the given userId. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.users.userId = :userId and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatRoomParticipants by using roomId as a search criteria.
	 * 
	 * @param roomId
	 * @return An Object ChatRoomParticipants whose roomId is equals to the given roomId. If
	 *         no ChatRoomParticipants is found, this method returns null.
	 */
	@Query("select e from ChatRoomParticipants e where e.chatRooms.roomId = :roomId and e.isDeleted = :isDeleted")
	List<ChatRoomParticipants> findByRoomId(@Param("roomId")Integer roomId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of ChatRoomParticipants by using chatRoomParticipantsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of ChatRoomParticipants
	 * @throws DataAccessException,ParseException
	 */
	default List<ChatRoomParticipants> getByCriteria(Request<ChatRoomParticipantsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from ChatRoomParticipants e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.roomIde.userId desc";
		TypedQuery<ChatRoomParticipants> query = em.createQuery(req, ChatRoomParticipants.class);
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
	 * Finds count of ChatRoomParticipants by using chatRoomParticipantsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of ChatRoomParticipants
	 * 
	 */
	default Long count(Request<ChatRoomParticipantsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from ChatRoomParticipants e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.roomId e.userId desc";
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
	default String getWhereExpression(Request<ChatRoomParticipantsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ChatRoomParticipantsDto dto = request.getData() != null ? request.getData() : new ChatRoomParticipantsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ChatRoomParticipantsDto elt : request.getDatas()) {
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
	default String generateCriteria(ChatRoomParticipantsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
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
			if (dto.getRoomId()!= null && dto.getRoomId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("roomId", dto.getRoomId(), "e.chatRooms.roomId", "Integer", dto.getRoomIdParam(), param, index, locale));
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
