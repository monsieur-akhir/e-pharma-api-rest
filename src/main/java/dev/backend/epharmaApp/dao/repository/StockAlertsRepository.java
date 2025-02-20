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
import dev.backend.epharmaApp.dao.repository.customize._StockAlertsRepository;

/**
 * Repository : StockAlerts.
 */
@Repository
public interface StockAlertsRepository extends JpaRepository<StockAlerts, Integer>, _StockAlertsRepository {
	/**
	 * Finds StockAlerts by using alertId as a search criteria.
	 * 
	 * @param alertId
	 * @return An Object StockAlerts whose alertId is equals to the given alertId. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.alertId = :alertId and e.isDeleted = :isDeleted")
	StockAlerts findOne(@Param("alertId")Integer alertId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds StockAlerts by using currentQuantity as a search criteria.
	 * 
	 * @param currentQuantity
	 * @return An Object StockAlerts whose currentQuantity is equals to the given currentQuantity. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.currentQuantity = :currentQuantity and e.isDeleted = :isDeleted")
	List<StockAlerts> findByCurrentQuantity(@Param("currentQuantity")Integer currentQuantity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using reorderLevel as a search criteria.
	 * 
	 * @param reorderLevel
	 * @return An Object StockAlerts whose reorderLevel is equals to the given reorderLevel. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.reorderLevel = :reorderLevel and e.isDeleted = :isDeleted")
	List<StockAlerts> findByReorderLevel(@Param("reorderLevel")Integer reorderLevel, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using alertDate as a search criteria.
	 * 
	 * @param alertDate
	 * @return An Object StockAlerts whose alertDate is equals to the given alertDate. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.alertDate = :alertDate and e.isDeleted = :isDeleted")
	List<StockAlerts> findByAlertDate(@Param("alertDate")Date alertDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using alertSent as a search criteria.
	 * 
	 * @param alertSent
	 * @return An Object StockAlerts whose alertSent is equals to the given alertSent. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.alertSent = :alertSent and e.isDeleted = :isDeleted")
	List<StockAlerts> findByAlertSent(@Param("alertSent")Boolean alertSent, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object StockAlerts whose recordStatus is equals to the given recordStatus. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<StockAlerts> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object StockAlerts whose createdAt is equals to the given createdAt. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<StockAlerts> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object StockAlerts whose createdBy is equals to the given createdBy. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<StockAlerts> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object StockAlerts whose updatedAt is equals to the given updatedAt. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<StockAlerts> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object StockAlerts whose updatedBy is equals to the given updatedBy. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<StockAlerts> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object StockAlerts whose isDeleted is equals to the given isDeleted. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.isDeleted = :isDeleted")
	List<StockAlerts> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object StockAlerts whose deletedAt is equals to the given deletedAt. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<StockAlerts> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds StockAlerts by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object StockAlerts whose deletedBy is equals to the given deletedBy. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<StockAlerts> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds StockAlerts by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object StockAlerts whose productId is equals to the given productId. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.products.productId = :productId and e.isDeleted = :isDeleted")
	List<StockAlerts> findByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds StockAlerts by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object StockAlerts whose pharmacyId is equals to the given pharmacyId. If
	 *         no StockAlerts is found, this method returns null.
	 */
	@Query("select e from StockAlerts e where e.pharmacies.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	List<StockAlerts> findByPharmacyId(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of StockAlerts by using stockAlertsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of StockAlerts
	 * @throws DataAccessException,ParseException
	 */
	default List<StockAlerts> getByCriteria(Request<StockAlertsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from StockAlerts e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.alertId desc";
		TypedQuery<StockAlerts> query = em.createQuery(req, StockAlerts.class);
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
	 * Finds count of StockAlerts by using stockAlertsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of StockAlerts
	 * 
	 */
	default Long count(Request<StockAlertsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from StockAlerts e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.alertId desc";
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
	default String getWhereExpression(Request<StockAlertsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		StockAlertsDto dto = request.getData() != null ? request.getData() : new StockAlertsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (StockAlertsDto elt : request.getDatas()) {
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
	default String generateCriteria(StockAlertsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getAlertId()!= null && dto.getAlertId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("alertId", dto.getAlertId(), "e.alertId", "Integer", dto.getAlertIdParam(), param, index, locale));
			}
			if (dto.getCurrentQuantity()!= null && dto.getCurrentQuantity() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("currentQuantity", dto.getCurrentQuantity(), "e.currentQuantity", "Integer", dto.getCurrentQuantityParam(), param, index, locale));
			}
			if (dto.getReorderLevel()!= null && dto.getReorderLevel() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("reorderLevel", dto.getReorderLevel(), "e.reorderLevel", "Integer", dto.getReorderLevelParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getAlertDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("alertDate", dto.getAlertDate(), "e.alertDate", "Date", dto.getAlertDateParam(), param, index, locale));
			}
			if (dto.getAlertSent()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("alertSent", dto.getAlertSent(), "e.alertSent", "Boolean", dto.getAlertSentParam(), param, index, locale));
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
