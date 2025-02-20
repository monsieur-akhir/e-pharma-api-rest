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
import dev.backend.epharmaApp.dao.repository.customize._StockAuditRepository;

/**
 * Repository : StockAudit.
 */
@Repository
public interface StockAuditRepository extends JpaRepository<StockAudit, Integer>, _StockAuditRepository {
	/**
	 * Finds StockAudit by using auditId as a search criteria.
	 * 
	 * @param auditId
	 * @return An Object StockAudit whose auditId is equals to the given auditId. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.auditId = :auditId and e.isDeleted = :isDeleted")
	StockAudit findOne(@Param("auditId")Integer auditId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds StockAudit by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object StockAudit whose pharmacyId is equals to the given pharmacyId. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	List<StockAudit> findByPharmacyId(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object StockAudit whose productId is equals to the given productId. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.productId = :productId and e.isDeleted = :isDeleted")
	List<StockAudit> findByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using oldQuantity as a search criteria.
	 * 
	 * @param oldQuantity
	 * @return An Object StockAudit whose oldQuantity is equals to the given oldQuantity. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.oldQuantity = :oldQuantity and e.isDeleted = :isDeleted")
	List<StockAudit> findByOldQuantity(@Param("oldQuantity")Integer oldQuantity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using newQuantity as a search criteria.
	 * 
	 * @param newQuantity
	 * @return An Object StockAudit whose newQuantity is equals to the given newQuantity. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.newQuantity = :newQuantity and e.isDeleted = :isDeleted")
	List<StockAudit> findByNewQuantity(@Param("newQuantity")Integer newQuantity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using changeDate as a search criteria.
	 * 
	 * @param changeDate
	 * @return An Object StockAudit whose changeDate is equals to the given changeDate. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.changeDate = :changeDate and e.isDeleted = :isDeleted")
	List<StockAudit> findByChangeDate(@Param("changeDate")Date changeDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object StockAudit whose recordStatus is equals to the given recordStatus. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<StockAudit> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object StockAudit whose createdAt is equals to the given createdAt. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<StockAudit> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object StockAudit whose createdBy is equals to the given createdBy. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<StockAudit> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object StockAudit whose updatedAt is equals to the given updatedAt. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<StockAudit> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object StockAudit whose updatedBy is equals to the given updatedBy. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<StockAudit> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object StockAudit whose isDeleted is equals to the given isDeleted. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.isDeleted = :isDeleted")
	List<StockAudit> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object StockAudit whose deletedAt is equals to the given deletedAt. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<StockAudit> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAudit by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object StockAudit whose deletedBy is equals to the given deletedBy. If
	 *         no StockAudit is found, this method returns null.
	 */
	@Query("select e from StockAudit e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<StockAudit> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of StockAudit by using stockAuditDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of StockAudit
	 * @throws DataAccessException,ParseException
	 */
	default List<StockAudit> getByCriteria(Request<StockAuditDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from StockAudit e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.auditId desc";
		TypedQuery<StockAudit> query = em.createQuery(req, StockAudit.class);
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
	 * Finds count of StockAudit by using stockAuditDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of StockAudit
	 * 
	 */
	default Long count(Request<StockAuditDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from StockAudit e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.auditId desc";
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
	default String getWhereExpression(Request<StockAuditDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		StockAuditDto dto = request.getData() != null ? request.getData() : new StockAuditDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (StockAuditDto elt : request.getDatas()) {
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
	default String generateCriteria(StockAuditDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getAuditId()!= null && dto.getAuditId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("auditId", dto.getAuditId(), "e.auditId", "Integer", dto.getAuditIdParam(), param, index, locale));
			}
			if (dto.getPharmacyId()!= null && dto.getPharmacyId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("pharmacyId", dto.getPharmacyId(), "e.pharmacyId", "Integer", dto.getPharmacyIdParam(), param, index, locale));
			}
			if (dto.getProductId()!= null && dto.getProductId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("productId", dto.getProductId(), "e.productId", "Integer", dto.getProductIdParam(), param, index, locale));
			}
			if (dto.getOldQuantity()!= null && dto.getOldQuantity() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("oldQuantity", dto.getOldQuantity(), "e.oldQuantity", "Integer", dto.getOldQuantityParam(), param, index, locale));
			}
			if (dto.getNewQuantity()!= null && dto.getNewQuantity() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("newQuantity", dto.getNewQuantity(), "e.newQuantity", "Integer", dto.getNewQuantityParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getChangeDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("changeDate", dto.getChangeDate(), "e.changeDate", "Date", dto.getChangeDateParam(), param, index, locale));
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
