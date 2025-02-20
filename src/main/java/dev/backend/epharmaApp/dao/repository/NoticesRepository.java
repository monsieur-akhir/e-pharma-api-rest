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
import dev.backend.epharmaApp.dao.repository.customize._NoticesRepository;

/**
 * Repository : Notices.
 */
@Repository
public interface NoticesRepository extends JpaRepository<Notices, Integer>, _NoticesRepository {
	/**
	 * Finds Notices by using noticeId as a search criteria.
	 * 
	 * @param noticeId
	 * @return An Object Notices whose noticeId is equals to the given noticeId. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.noticeId = :noticeId and e.isDeleted = :isDeleted")
	Notices findOne(@Param("noticeId")Integer noticeId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Notices by using title as a search criteria.
	 * 
	 * @param title
	 * @return An Object Notices whose title is equals to the given title. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.title = :title and e.isDeleted = :isDeleted")
	List<Notices> findByTitle(@Param("title")String title, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using content as a search criteria.
	 * 
	 * @param content
	 * @return An Object Notices whose content is equals to the given content. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.content = :content and e.isDeleted = :isDeleted")
	List<Notices> findByContent(@Param("content")String content, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Notices whose recordStatus is equals to the given recordStatus. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Notices> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Notices whose createdAt is equals to the given createdAt. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Notices> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Notices whose createdBy is equals to the given createdBy. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Notices> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Notices whose updatedAt is equals to the given updatedAt. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Notices> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Notices whose updatedBy is equals to the given updatedBy. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Notices> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Notices whose isDeleted is equals to the given isDeleted. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.isDeleted = :isDeleted")
	List<Notices> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Notices whose deletedAt is equals to the given deletedAt. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Notices> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Notices by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Notices whose deletedBy is equals to the given deletedBy. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Notices> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Notices by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object Notices whose productId is equals to the given productId. If
	 *         no Notices is found, this method returns null.
	 */
	@Query("select e from Notices e where e.products.productId = :productId and e.isDeleted = :isDeleted")
	List<Notices> findByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Notices by using noticesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Notices
	 * @throws DataAccessException,ParseException
	 */
	default List<Notices> getByCriteria(Request<NoticesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Notices e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.noticeId desc";
		TypedQuery<Notices> query = em.createQuery(req, Notices.class);
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
	 * Finds count of Notices by using noticesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Notices
	 * 
	 */
	default Long count(Request<NoticesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Notices e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.noticeId desc";
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
	default String getWhereExpression(Request<NoticesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		NoticesDto dto = request.getData() != null ? request.getData() : new NoticesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (NoticesDto elt : request.getDatas()) {
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
	default String generateCriteria(NoticesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getNoticeId()!= null && dto.getNoticeId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("noticeId", dto.getNoticeId(), "e.noticeId", "Integer", dto.getNoticeIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getTitle())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("title", dto.getTitle(), "e.title", "String", dto.getTitleParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getContent())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("content", dto.getContent(), "e.content", "String", dto.getContentParam(), param, index, locale));
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
			if (dto.getProductId()!= null && dto.getProductId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("productId", dto.getProductId(), "e.products.productId", "Integer", dto.getProductIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
