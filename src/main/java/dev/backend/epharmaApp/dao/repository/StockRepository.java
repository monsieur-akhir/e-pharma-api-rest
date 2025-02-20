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
import dev.backend.epharmaApp.dao.entity.StockKey;
import dev.backend.epharmaApp.dao.repository.customize._StockRepository;

/**
 * Repository : Stock.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, StockKey>, _StockRepository {
	/**
	 * Finds Stock by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object Stock whose pharmacyId is equals to the given pharmacyId. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.pharmacies.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	Stock findOneByPharmacyId(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Stock by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object Stock whose productId is equals to the given productId. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.products.productId = :productId and e.isDeleted = :isDeleted")
	Stock findOneByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Stock by using quantity as a search criteria.
	 * 
	 * @param quantity
	 * @return An Object Stock whose quantity is equals to the given quantity. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.quantity = :quantity and e.isDeleted = :isDeleted")
	List<Stock> findByQuantity(@Param("quantity")Integer quantity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using reorderLevel as a search criteria.
	 * 
	 * @param reorderLevel
	 * @return An Object Stock whose reorderLevel is equals to the given reorderLevel. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.reorderLevel = :reorderLevel and e.isDeleted = :isDeleted")
	List<Stock> findByReorderLevel(@Param("reorderLevel")Integer reorderLevel, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Stock whose recordStatus is equals to the given recordStatus. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Stock> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Stock whose createdAt is equals to the given createdAt. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Stock> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Stock whose createdBy is equals to the given createdBy. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Stock> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Stock whose updatedAt is equals to the given updatedAt. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Stock> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Stock whose updatedBy is equals to the given updatedBy. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Stock> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Stock whose isDeleted is equals to the given isDeleted. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.isDeleted = :isDeleted")
	List<Stock> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Stock whose deletedAt is equals to the given deletedAt. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Stock> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Stock by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Stock whose deletedBy is equals to the given deletedBy. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Stock> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Stock by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object Stock whose productId is equals to the given productId. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.products.productId = :productId and e.isDeleted = :isDeleted")
	List<Stock> findByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Stock by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object Stock whose pharmacyId is equals to the given pharmacyId. If
	 *         no Stock is found, this method returns null.
	 */
	@Query("select e from Stock e where e.pharmacies.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	List<Stock> findByPharmacyId(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Stock by using stockDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Stock
	 * @throws DataAccessException,ParseException
	 */
	default List<Stock> getByCriteria(Request<StockDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Stock e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.pharmacyIde.productId desc";
		TypedQuery<Stock> query = em.createQuery(req, Stock.class);
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
	 * Finds count of Stock by using stockDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Stock
	 * 
	 */
	default Long count(Request<StockDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Stock e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.pharmacyId e.productId desc";
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
	default String getWhereExpression(Request<StockDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		StockDto dto = request.getData() != null ? request.getData() : new StockDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (StockDto elt : request.getDatas()) {
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
	default String generateCriteria(StockDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getQuantity()!= null && dto.getQuantity() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("quantity", dto.getQuantity(), "e.quantity", "Integer", dto.getQuantityParam(), param, index, locale));
			}
			if (dto.getReorderLevel()!= null && dto.getReorderLevel() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("reorderLevel", dto.getReorderLevel(), "e.reorderLevel", "Integer", dto.getReorderLevelParam(), param, index, locale));
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
