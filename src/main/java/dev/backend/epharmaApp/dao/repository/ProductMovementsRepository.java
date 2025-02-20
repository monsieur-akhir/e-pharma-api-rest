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
import dev.backend.epharmaApp.dao.repository.customize._ProductMovementsRepository;

/**
 * Repository : ProductMovements.
 */
@Repository
public interface ProductMovementsRepository extends JpaRepository<ProductMovements, Integer>, _ProductMovementsRepository {
	/**
	 * Finds ProductMovements by using movementId as a search criteria.
	 * 
	 * @param movementId
	 * @return An Object ProductMovements whose movementId is equals to the given movementId. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.movementId = :movementId and e.isDeleted = :isDeleted")
	ProductMovements findOne(@Param("movementId")Integer movementId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ProductMovements by using fromEntity as a search criteria.
	 * 
	 * @param fromEntity
	 * @return An Object ProductMovements whose fromEntity is equals to the given fromEntity. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.fromEntity = :fromEntity and e.isDeleted = :isDeleted")
	List<ProductMovements> findByFromEntity(@Param("fromEntity")String fromEntity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using toEntity as a search criteria.
	 * 
	 * @param toEntity
	 * @return An Object ProductMovements whose toEntity is equals to the given toEntity. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.toEntity = :toEntity and e.isDeleted = :isDeleted")
	List<ProductMovements> findByToEntity(@Param("toEntity")String toEntity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using movementDate as a search criteria.
	 * 
	 * @param movementDate
	 * @return An Object ProductMovements whose movementDate is equals to the given movementDate. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.movementDate = :movementDate and e.isDeleted = :isDeleted")
	List<ProductMovements> findByMovementDate(@Param("movementDate")Date movementDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using quantity as a search criteria.
	 * 
	 * @param quantity
	 * @return An Object ProductMovements whose quantity is equals to the given quantity. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.quantity = :quantity and e.isDeleted = :isDeleted")
	List<ProductMovements> findByQuantity(@Param("quantity")Integer quantity, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using remarks as a search criteria.
	 * 
	 * @param remarks
	 * @return An Object ProductMovements whose remarks is equals to the given remarks. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.remarks = :remarks and e.isDeleted = :isDeleted")
	List<ProductMovements> findByRemarks(@Param("remarks")String remarks, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object ProductMovements whose recordStatus is equals to the given recordStatus. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<ProductMovements> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object ProductMovements whose createdAt is equals to the given createdAt. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<ProductMovements> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object ProductMovements whose createdBy is equals to the given createdBy. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<ProductMovements> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object ProductMovements whose updatedAt is equals to the given updatedAt. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<ProductMovements> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object ProductMovements whose updatedBy is equals to the given updatedBy. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<ProductMovements> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object ProductMovements whose isDeleted is equals to the given isDeleted. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.isDeleted = :isDeleted")
	List<ProductMovements> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object ProductMovements whose deletedAt is equals to the given deletedAt. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<ProductMovements> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductMovements by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object ProductMovements whose deletedBy is equals to the given deletedBy. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<ProductMovements> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ProductMovements by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object ProductMovements whose productId is equals to the given productId. If
	 *         no ProductMovements is found, this method returns null.
	 */
	@Query("select e from ProductMovements e where e.products.productId = :productId and e.isDeleted = :isDeleted")
	List<ProductMovements> findByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of ProductMovements by using productMovementsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of ProductMovements
	 * @throws DataAccessException,ParseException
	 */
	default List<ProductMovements> getByCriteria(Request<ProductMovementsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from ProductMovements e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.movementId desc";
		TypedQuery<ProductMovements> query = em.createQuery(req, ProductMovements.class);
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
	 * Finds count of ProductMovements by using productMovementsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of ProductMovements
	 * 
	 */
	default Long count(Request<ProductMovementsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from ProductMovements e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.movementId desc";
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
	default String getWhereExpression(Request<ProductMovementsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ProductMovementsDto dto = request.getData() != null ? request.getData() : new ProductMovementsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ProductMovementsDto elt : request.getDatas()) {
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
	default String generateCriteria(ProductMovementsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getMovementId()!= null && dto.getMovementId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("movementId", dto.getMovementId(), "e.movementId", "Integer", dto.getMovementIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFromEntity())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("fromEntity", dto.getFromEntity(), "e.fromEntity", "String", dto.getFromEntityParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getToEntity())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("toEntity", dto.getToEntity(), "e.toEntity", "String", dto.getToEntityParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getMovementDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("movementDate", dto.getMovementDate(), "e.movementDate", "Date", dto.getMovementDateParam(), param, index, locale));
			}
			if (dto.getQuantity()!= null && dto.getQuantity() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("quantity", dto.getQuantity(), "e.quantity", "Integer", dto.getQuantityParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getRemarks())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("remarks", dto.getRemarks(), "e.remarks", "String", dto.getRemarksParam(), param, index, locale));
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
