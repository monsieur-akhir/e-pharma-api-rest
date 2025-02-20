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
import dev.backend.epharmaApp.dao.repository.customize._ChatMessagesRepository;

/**
 * Repository : ChatMessages.
 */
@Repository
public interface ChatMessagesRepository extends JpaRepository<ChatMessages, Integer>, _ChatMessagesRepository {
	/**
	 * Finds ChatMessages by using messageId as a search criteria.
	 * 
	 * @param messageId
	 * @return An Object ChatMessages whose messageId is equals to the given messageId. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.messageId = :messageId and e.isDeleted = :isDeleted")
	ChatMessages findOne(@Param("messageId")Integer messageId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatMessages by using message as a search criteria.
	 * 
	 * @param message
	 * @return An Object ChatMessages whose message is equals to the given message. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.message = :message and e.isDeleted = :isDeleted")
	List<ChatMessages> findByMessage(@Param("message")String message, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using sentAt as a search criteria.
	 * 
	 * @param sentAt
	 * @return An Object ChatMessages whose sentAt is equals to the given sentAt. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.sentAt = :sentAt and e.isDeleted = :isDeleted")
	List<ChatMessages> findBySentAt(@Param("sentAt")Date sentAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object ChatMessages whose recordStatus is equals to the given recordStatus. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<ChatMessages> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object ChatMessages whose createdAt is equals to the given createdAt. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<ChatMessages> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object ChatMessages whose createdBy is equals to the given createdBy. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<ChatMessages> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object ChatMessages whose updatedAt is equals to the given updatedAt. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<ChatMessages> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object ChatMessages whose updatedBy is equals to the given updatedBy. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<ChatMessages> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object ChatMessages whose isDeleted is equals to the given isDeleted. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.isDeleted = :isDeleted")
	List<ChatMessages> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object ChatMessages whose deletedAt is equals to the given deletedAt. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<ChatMessages> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessages by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object ChatMessages whose deletedBy is equals to the given deletedBy. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<ChatMessages> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatMessages by using senderId as a search criteria.
	 * 
	 * @param senderId
	 * @return An Object ChatMessages whose senderId is equals to the given senderId. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.users.userId = :senderId and e.isDeleted = :isDeleted")
	List<ChatMessages> findBySenderId(@Param("senderId")Integer senderId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatMessages by using roomId as a search criteria.
	 * 
	 * @param roomId
	 * @return An Object ChatMessages whose roomId is equals to the given roomId. If
	 *         no ChatMessages is found, this method returns null.
	 */
	@Query("select e from ChatMessages e where e.chatRooms.roomId = :roomId and e.isDeleted = :isDeleted")
	List<ChatMessages> findByRoomId(@Param("roomId")Integer roomId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of ChatMessages by using chatMessagesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of ChatMessages
	 * @throws DataAccessException,ParseException
	 */
	default List<ChatMessages> getByCriteria(Request<ChatMessagesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from ChatMessages e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.messageId desc";
		TypedQuery<ChatMessages> query = em.createQuery(req, ChatMessages.class);
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
	 * Finds count of ChatMessages by using chatMessagesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of ChatMessages
	 * 
	 */
	default Long count(Request<ChatMessagesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from ChatMessages e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.messageId desc";
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
	default String getWhereExpression(Request<ChatMessagesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ChatMessagesDto dto = request.getData() != null ? request.getData() : new ChatMessagesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ChatMessagesDto elt : request.getDatas()) {
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
	default String generateCriteria(ChatMessagesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getMessageId()!= null && dto.getMessageId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("messageId", dto.getMessageId(), "e.messageId", "Integer", dto.getMessageIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getMessage())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("message", dto.getMessage(), "e.message", "String", dto.getMessageParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getSentAt())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("sentAt", dto.getSentAt(), "e.sentAt", "Date", dto.getSentAtParam(), param, index, locale));
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
			if (dto.getSenderId()!= null && dto.getSenderId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("senderId", dto.getSenderId(), "e.users.userId", "Integer", dto.getSenderIdParam(), param, index, locale));
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
