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
import dev.backend.epharmaApp.dao.repository.customize._ChatRoomsRepository;

/**
 * Repository : ChatRooms.
 */
@Repository
public interface ChatRoomsRepository extends JpaRepository<ChatRooms, Integer>, _ChatRoomsRepository {
	/**
	 * Finds ChatRooms by using roomId as a search criteria.
	 * 
	 * @param roomId
	 * @return An Object ChatRooms whose roomId is equals to the given roomId. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.roomId = :roomId and e.isDeleted = :isDeleted")
	ChatRooms findOne(@Param("roomId")Integer roomId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatRooms by using roomName as a search criteria.
	 * 
	 * @param roomName
	 * @return An Object ChatRooms whose roomName is equals to the given roomName. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.roomName = :roomName and e.isDeleted = :isDeleted")
	List<ChatRooms> findByRoomName(@Param("roomName")String roomName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object ChatRooms whose recordStatus is equals to the given recordStatus. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<ChatRooms> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object ChatRooms whose createdAt is equals to the given createdAt. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<ChatRooms> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object ChatRooms whose createdBy is equals to the given createdBy. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<ChatRooms> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object ChatRooms whose updatedAt is equals to the given updatedAt. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<ChatRooms> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object ChatRooms whose updatedBy is equals to the given updatedBy. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<ChatRooms> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object ChatRooms whose isDeleted is equals to the given isDeleted. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.isDeleted = :isDeleted")
	List<ChatRooms> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object ChatRooms whose deletedAt is equals to the given deletedAt. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<ChatRooms> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatRooms by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object ChatRooms whose deletedBy is equals to the given deletedBy. If
	 *         no ChatRooms is found, this method returns null.
	 */
	@Query("select e from ChatRooms e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<ChatRooms> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of ChatRooms by using chatRoomsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of ChatRooms
	 * @throws DataAccessException,ParseException
	 */
	default List<ChatRooms> getByCriteria(Request<ChatRoomsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from ChatRooms e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.roomId desc";
		TypedQuery<ChatRooms> query = em.createQuery(req, ChatRooms.class);
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
	 * Finds count of ChatRooms by using chatRoomsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of ChatRooms
	 * 
	 */
	default Long count(Request<ChatRoomsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from ChatRooms e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.roomId desc";
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
	default String getWhereExpression(Request<ChatRoomsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ChatRoomsDto dto = request.getData() != null ? request.getData() : new ChatRoomsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ChatRoomsDto elt : request.getDatas()) {
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
	default String generateCriteria(ChatRoomsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getRoomId()!= null && dto.getRoomId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("roomId", dto.getRoomId(), "e.roomId", "Integer", dto.getRoomIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getRoomName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("roomName", dto.getRoomName(), "e.roomName", "String", dto.getRoomNameParam(), param, index, locale));
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
