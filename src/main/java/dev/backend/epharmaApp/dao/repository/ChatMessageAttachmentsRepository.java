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
import dev.backend.epharmaApp.dao.repository.customize._ChatMessageAttachmentsRepository;

/**
 * Repository : ChatMessageAttachments.
 */
@Repository
public interface ChatMessageAttachmentsRepository extends JpaRepository<ChatMessageAttachments, Integer>, _ChatMessageAttachmentsRepository {
	/**
	 * Finds ChatMessageAttachments by using attachmentId as a search criteria.
	 * 
	 * @param attachmentId
	 * @return An Object ChatMessageAttachments whose attachmentId is equals to the given attachmentId. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.attachmentId = :attachmentId and e.isDeleted = :isDeleted")
	ChatMessageAttachments findOne(@Param("attachmentId")Integer attachmentId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatMessageAttachments by using fileType as a search criteria.
	 * 
	 * @param fileType
	 * @return An Object ChatMessageAttachments whose fileType is equals to the given fileType. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.fileType = :fileType and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByFileType(@Param("fileType")String fileType, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using fileName as a search criteria.
	 * 
	 * @param fileName
	 * @return An Object ChatMessageAttachments whose fileName is equals to the given fileName. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.fileName = :fileName and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByFileName(@Param("fileName")String fileName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using fileData as a search criteria.
	 * 
	 * @param fileData
	 * @return An Object ChatMessageAttachments whose fileData is equals to the given fileData. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.fileData = :fileData and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByFileData(@Param("fileData")String fileData, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object ChatMessageAttachments whose recordStatus is equals to the given recordStatus. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object ChatMessageAttachments whose createdAt is equals to the given createdAt. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object ChatMessageAttachments whose createdBy is equals to the given createdBy. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object ChatMessageAttachments whose updatedAt is equals to the given updatedAt. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object ChatMessageAttachments whose updatedBy is equals to the given updatedBy. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object ChatMessageAttachments whose isDeleted is equals to the given isDeleted. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object ChatMessageAttachments whose deletedAt is equals to the given deletedAt. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ChatMessageAttachments by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object ChatMessageAttachments whose deletedBy is equals to the given deletedBy. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ChatMessageAttachments by using messageId as a search criteria.
	 * 
	 * @param messageId
	 * @return An Object ChatMessageAttachments whose messageId is equals to the given messageId. If
	 *         no ChatMessageAttachments is found, this method returns null.
	 */
	@Query("select e from ChatMessageAttachments e where e.chatMessages.messageId = :messageId and e.isDeleted = :isDeleted")
	List<ChatMessageAttachments> findByMessageId(@Param("messageId")Integer messageId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of ChatMessageAttachments by using chatMessageAttachmentsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of ChatMessageAttachments
	 * @throws DataAccessException,ParseException
	 */
	default List<ChatMessageAttachments> getByCriteria(Request<ChatMessageAttachmentsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from ChatMessageAttachments e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.attachmentId desc";
		TypedQuery<ChatMessageAttachments> query = em.createQuery(req, ChatMessageAttachments.class);
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
	 * Finds count of ChatMessageAttachments by using chatMessageAttachmentsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of ChatMessageAttachments
	 * 
	 */
	default Long count(Request<ChatMessageAttachmentsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from ChatMessageAttachments e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.attachmentId desc";
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
	default String getWhereExpression(Request<ChatMessageAttachmentsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ChatMessageAttachmentsDto dto = request.getData() != null ? request.getData() : new ChatMessageAttachmentsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ChatMessageAttachmentsDto elt : request.getDatas()) {
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
	default String generateCriteria(ChatMessageAttachmentsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getAttachmentId()!= null && dto.getAttachmentId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("attachmentId", dto.getAttachmentId(), "e.attachmentId", "Integer", dto.getAttachmentIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFileType())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("fileType", dto.getFileType(), "e.fileType", "String", dto.getFileTypeParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFileName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("fileName", dto.getFileName(), "e.fileName", "String", dto.getFileNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFileData())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("fileData", dto.getFileData(), "e.fileData", "String", dto.getFileDataParam(), param, index, locale));
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
			if (dto.getMessageId()!= null && dto.getMessageId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("messageId", dto.getMessageId(), "e.chatMessages.messageId", "Integer", dto.getMessageIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
