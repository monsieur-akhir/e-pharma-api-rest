package dev.backend.epharmaApp.dao.repository;

import java.math.BigDecimal;
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
import dev.backend.epharmaApp.dao.repository.customize._PurchaseOrderItemsRepository;

/**
 * Repository : PurchaseOrderItems.
 */
@Repository
public interface PurchaseOrderItemsRepository extends JpaRepository<PurchaseOrderItems, Integer>, _PurchaseOrderItemsRepository {
	/**
	 * Finds PurchaseOrderItems by using poItemId as a search criteria.
	 * 
	 * @param poItemId
	 * @return An Object PurchaseOrderItems whose poItemId is equals to the given poItemId. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.poItemId = :poItemId and e.isDeleted = :isDeleted")
	PurchaseOrderItems findOne(@Param("poItemId")Integer poItemId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PurchaseOrderItems by using quantity as a search criteria.
	 * 
	 * @param quantity
	 * @return An Object PurchaseOrderItems whose quantity is equals to the given quantity. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.quantity = :quantity and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByQuantity(@Param("quantity")Integer quantity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using unitPrice as a search criteria.
	 * 
	 * @param unitPrice
	 * @return An Object PurchaseOrderItems whose unitPrice is equals to the given unitPrice. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.unitPrice = :unitPrice and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByUnitPrice(@Param("unitPrice")BigDecimal unitPrice, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using totalPrice as a search criteria.
	 * 
	 * @param totalPrice
	 * @return An Object PurchaseOrderItems whose totalPrice is equals to the given totalPrice. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.totalPrice = :totalPrice and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByTotalPrice(@Param("totalPrice")BigDecimal totalPrice, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object PurchaseOrderItems whose recordStatus is equals to the given recordStatus. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object PurchaseOrderItems whose createdAt is equals to the given createdAt. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object PurchaseOrderItems whose createdBy is equals to the given createdBy. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object PurchaseOrderItems whose updatedAt is equals to the given updatedAt. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object PurchaseOrderItems whose updatedBy is equals to the given updatedBy. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object PurchaseOrderItems whose isDeleted is equals to the given isDeleted. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object PurchaseOrderItems whose deletedAt is equals to the given deletedAt. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrderItems by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object PurchaseOrderItems whose deletedBy is equals to the given deletedBy. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PurchaseOrderItems by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object PurchaseOrderItems whose productId is equals to the given productId. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.products.productId = :productId and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PurchaseOrderItems by using poId as a search criteria.
	 * 
	 * @param poId
	 * @return An Object PurchaseOrderItems whose poId is equals to the given poId. If
	 *         no PurchaseOrderItems is found, this method returns null.
	 */
	@Query("select e from PurchaseOrderItems e where e.purchaseOrders.poId = :poId and e.isDeleted = :isDeleted")
	List<PurchaseOrderItems> findByPoId(@Param("poId")Integer poId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of PurchaseOrderItems by using purchaseOrderItemsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of PurchaseOrderItems
	 * @throws DataAccessException,ParseException
	 */
	default List<PurchaseOrderItems> getByCriteria(Request<PurchaseOrderItemsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from PurchaseOrderItems e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.poItemId desc";
		TypedQuery<PurchaseOrderItems> query = em.createQuery(req, PurchaseOrderItems.class);
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
	 * Finds count of PurchaseOrderItems by using purchaseOrderItemsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of PurchaseOrderItems
	 * 
	 */
	default Long count(Request<PurchaseOrderItemsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from PurchaseOrderItems e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.poItemId desc";
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
	default String getWhereExpression(Request<PurchaseOrderItemsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		PurchaseOrderItemsDto dto = request.getData() != null ? request.getData() : new PurchaseOrderItemsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (PurchaseOrderItemsDto elt : request.getDatas()) {
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
	default String generateCriteria(PurchaseOrderItemsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getPoItemId()!= null && dto.getPoItemId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("poItemId", dto.getPoItemId(), "e.poItemId", "Integer", dto.getPoItemIdParam(), param, index, locale));
			}
			if (dto.getQuantity()!= null && dto.getQuantity() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("quantity", dto.getQuantity(), "e.quantity", "Integer", dto.getQuantityParam(), param, index, locale));
			}
			if (dto.getUnitPrice()!= null && dto.getUnitPrice().intValue() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("unitPrice", dto.getUnitPrice(), "e.unitPrice", "BigDecimal", dto.getUnitPriceParam(), param, index, locale));
			}
			if (dto.getTotalPrice()!= null && dto.getTotalPrice().intValue() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("totalPrice", dto.getTotalPrice(), "e.totalPrice", "BigDecimal", dto.getTotalPriceParam(), param, index, locale));
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
			if (dto.getPoId()!= null && dto.getPoId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("poId", dto.getPoId(), "e.purchaseOrders.poId", "Integer", dto.getPoIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
