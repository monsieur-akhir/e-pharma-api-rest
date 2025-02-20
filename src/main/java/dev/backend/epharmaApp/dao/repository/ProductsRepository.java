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
import dev.backend.epharmaApp.dao.repository.customize._ProductsRepository;

/**
 * Repository : Products.
 */
@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>, _ProductsRepository {
	/**
	 * Finds Products by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object Products whose productId is equals to the given productId. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.productId = :productId and e.isDeleted = :isDeleted")
	Products findOne(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Products by using productName as a search criteria.
	 * 
	 * @param productName
	 * @return An Object Products whose productName is equals to the given productName. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.productName = :productName and e.isDeleted = :isDeleted")
	List<Products> findByProductName(@Param("productName")String productName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using genericName as a search criteria.
	 * 
	 * @param genericName
	 * @return An Object Products whose genericName is equals to the given genericName. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.genericName = :genericName and e.isDeleted = :isDeleted")
	List<Products> findByGenericName(@Param("genericName")String genericName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using brandName as a search criteria.
	 * 
	 * @param brandName
	 * @return An Object Products whose brandName is equals to the given brandName. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.brandName = :brandName and e.isDeleted = :isDeleted")
	List<Products> findByBrandName(@Param("brandName")String brandName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using description as a search criteria.
	 * 
	 * @param description
	 * @return An Object Products whose description is equals to the given description. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.description = :description and e.isDeleted = :isDeleted")
	List<Products> findByDescription(@Param("description")String description, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using dosage as a search criteria.
	 * 
	 * @param dosage
	 * @return An Object Products whose dosage is equals to the given dosage. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.dosage = :dosage and e.isDeleted = :isDeleted")
	List<Products> findByDosage(@Param("dosage")String dosage, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using price as a search criteria.
	 * 
	 * @param price
	 * @return An Object Products whose price is equals to the given price. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.price = :price and e.isDeleted = :isDeleted")
	List<Products> findByPrice(@Param("price")BigDecimal price, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using barcode as a search criteria.
	 * 
	 * @param barcode
	 * @return An Object Products whose barcode is equals to the given barcode. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.barcode = :barcode and e.isDeleted = :isDeleted")
	List<Products> findByBarcode(@Param("barcode")String barcode, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using expirationDate as a search criteria.
	 * 
	 * @param expirationDate
	 * @return An Object Products whose expirationDate is equals to the given expirationDate. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.expirationDate = :expirationDate and e.isDeleted = :isDeleted")
	List<Products> findByExpirationDate(@Param("expirationDate")Date expirationDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Products whose recordStatus is equals to the given recordStatus. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Products> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Products whose createdAt is equals to the given createdAt. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Products> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Products whose createdBy is equals to the given createdBy. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Products> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Products whose updatedAt is equals to the given updatedAt. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Products> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Products whose updatedBy is equals to the given updatedBy. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Products> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Products whose isDeleted is equals to the given isDeleted. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.isDeleted = :isDeleted")
	List<Products> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Products whose deletedAt is equals to the given deletedAt. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Products> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Products by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Products whose deletedBy is equals to the given deletedBy. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Products> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Products by using categoryId as a search criteria.
	 * 
	 * @param categoryId
	 * @return An Object Products whose categoryId is equals to the given categoryId. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.productCategories.categoryId = :categoryId and e.isDeleted = :isDeleted")
	List<Products> findByCategoryId(@Param("categoryId")Integer categoryId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Products by using manufacturerId as a search criteria.
	 * 
	 * @param manufacturerId
	 * @return An Object Products whose manufacturerId is equals to the given manufacturerId. If
	 *         no Products is found, this method returns null.
	 */
	@Query("select e from Products e where e.manufacturers.manufacturerId = :manufacturerId and e.isDeleted = :isDeleted")
	List<Products> findByManufacturerId(@Param("manufacturerId")Integer manufacturerId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Products by using productsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Products
	 * @throws DataAccessException,ParseException
	 */
	default List<Products> getByCriteria(Request<ProductsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Products e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.productId desc";
		TypedQuery<Products> query = em.createQuery(req, Products.class);
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
	 * Finds count of Products by using productsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Products
	 * 
	 */
	default Long count(Request<ProductsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Products e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.productId desc";
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
	default String getWhereExpression(Request<ProductsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ProductsDto dto = request.getData() != null ? request.getData() : new ProductsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ProductsDto elt : request.getDatas()) {
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
	default String generateCriteria(ProductsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getProductId()!= null && dto.getProductId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("productId", dto.getProductId(), "e.productId", "Integer", dto.getProductIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getProductName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("productName", dto.getProductName(), "e.productName", "String", dto.getProductNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getGenericName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("genericName", dto.getGenericName(), "e.genericName", "String", dto.getGenericNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getBrandName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("brandName", dto.getBrandName(), "e.brandName", "String", dto.getBrandNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDescription())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("description", dto.getDescription(), "e.description", "String", dto.getDescriptionParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDosage())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("dosage", dto.getDosage(), "e.dosage", "String", dto.getDosageParam(), param, index, locale));
			}
			if (dto.getPrice()!= null && dto.getPrice().intValue() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("price", dto.getPrice(), "e.price", "BigDecimal", dto.getPriceParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getBarcode())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("barcode", dto.getBarcode(), "e.barcode", "String", dto.getBarcodeParam(), param, index, locale));
			}
			if (dto.getExpirationDate()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("expirationDate", dto.getExpirationDate(), "e.expirationDate", "Date", dto.getExpirationDateParam(), param, index, locale));
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
			if (dto.getCategoryId()!= null && dto.getCategoryId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("categoryId", dto.getCategoryId(), "e.productCategories.categoryId", "Integer", dto.getCategoryIdParam(), param, index, locale));
			}
			if (dto.getManufacturerId()!= null && dto.getManufacturerId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("manufacturerId", dto.getManufacturerId(), "e.manufacturers.manufacturerId", "Integer", dto.getManufacturerIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
