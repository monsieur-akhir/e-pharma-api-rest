package dev.backend.epharmaApp.dao.repository;

import java.math.BigDecimal;
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
import dev.backend.epharmaApp.dao.repository.customize._PurchaseOrdersRepository;

/**
 * Repository : PurchaseOrders.
 */
@Repository
public interface PurchaseOrdersRepository extends JpaRepository<PurchaseOrders, Integer>, _PurchaseOrdersRepository {
	/**
	 * Finds PurchaseOrders by using poId as a search criteria.
	 * 
	 * @param poId
	 * @return An Object PurchaseOrders whose poId is equals to the given poId. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.poId = :poId and e.isDeleted = :isDeleted")
	PurchaseOrders findOne(@Param("poId")Integer poId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PurchaseOrders by using orderDate as a search criteria.
	 * 
	 * @param orderDate
	 * @return An Object PurchaseOrders whose orderDate is equals to the given orderDate. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.orderDate = :orderDate and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByOrderDate(@Param("orderDate")Date orderDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using status as a search criteria.
	 * 
	 * @param status
	 * @return An Object PurchaseOrders whose status is equals to the given status. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.status = :status and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByStatus(@Param("status")String status, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using totalAmount as a search criteria.
	 * 
	 * @param totalAmount
	 * @return An Object PurchaseOrders whose totalAmount is equals to the given totalAmount. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.totalAmount = :totalAmount and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByTotalAmount(@Param("totalAmount")BigDecimal totalAmount, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object PurchaseOrders whose recordStatus is equals to the given recordStatus. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object PurchaseOrders whose createdAt is equals to the given createdAt. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object PurchaseOrders whose createdBy is equals to the given createdBy. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object PurchaseOrders whose updatedAt is equals to the given updatedAt. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object PurchaseOrders whose updatedBy is equals to the given updatedBy. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object PurchaseOrders whose isDeleted is equals to the given isDeleted. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object PurchaseOrders whose deletedAt is equals to the given deletedAt. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PurchaseOrders by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object PurchaseOrders whose deletedBy is equals to the given deletedBy. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PurchaseOrders by using manufacturerId as a search criteria.
	 * 
	 * @param manufacturerId
	 * @return An Object PurchaseOrders whose manufacturerId is equals to the given manufacturerId. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.manufacturers.manufacturerId = :manufacturerId and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByManufacturerId(@Param("manufacturerId")Integer manufacturerId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PurchaseOrders by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object PurchaseOrders whose pharmacyId is equals to the given pharmacyId. If
	 *         no PurchaseOrders is found, this method returns null.
	 */
	@Query("select e from PurchaseOrders e where e.pharmacies.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	List<PurchaseOrders> findByPharmacyId(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of PurchaseOrders by using purchaseOrdersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of PurchaseOrders
	 * @throws DataAccessException,ParseException
	 */
	default List<PurchaseOrders> getByCriteria(Request<PurchaseOrdersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from PurchaseOrders e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.poId desc";
		TypedQuery<PurchaseOrders> query = em.createQuery(req, PurchaseOrders.class);
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
	 * Finds count of PurchaseOrders by using purchaseOrdersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of PurchaseOrders
	 * 
	 */
	default Long count(Request<PurchaseOrdersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from PurchaseOrders e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.poId desc";
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
	default String getWhereExpression(Request<PurchaseOrdersDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		PurchaseOrdersDto dto = request.getData() != null ? request.getData() : new PurchaseOrdersDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (PurchaseOrdersDto elt : request.getDatas()) {
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
	default String generateCriteria(PurchaseOrdersDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getPoId()!= null && dto.getPoId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("poId", dto.getPoId(), "e.poId", "Integer", dto.getPoIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getOrderDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("orderDate", dto.getOrderDate(), "e.orderDate", "Date", dto.getOrderDateParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getStatus())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("status", dto.getStatus(), "e.status", "String", dto.getStatusParam(), param, index, locale));
			}
			if (dto.getTotalAmount()!= null && dto.getTotalAmount().intValue() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("totalAmount", dto.getTotalAmount(), "e.totalAmount", "BigDecimal", dto.getTotalAmountParam(), param, index, locale));
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
			if (dto.getManufacturerId()!= null && dto.getManufacturerId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("manufacturerId", dto.getManufacturerId(), "e.manufacturers.manufacturerId", "Integer", dto.getManufacturerIdParam(), param, index, locale));
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
