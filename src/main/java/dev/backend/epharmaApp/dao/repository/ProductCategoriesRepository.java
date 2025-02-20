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
import dev.backend.epharmaApp.dao.repository.customize._ProductCategoriesRepository;

/**
 * Repository : ProductCategories.
 */
@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Integer>, _ProductCategoriesRepository {
	/**
	 * Finds ProductCategories by using categoryId as a search criteria.
	 * 
	 * @param categoryId
	 * @return An Object ProductCategories whose categoryId is equals to the given categoryId. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.categoryId = :categoryId and e.isDeleted = :isDeleted")
	ProductCategories findOne(@Param("categoryId")Integer categoryId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ProductCategories by using categoryName as a search criteria.
	 * 
	 * @param categoryName
	 * @return An Object ProductCategories whose categoryName is equals to the given categoryName. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.categoryName = :categoryName and e.isDeleted = :isDeleted")
	List<ProductCategories> findByCategoryName(@Param("categoryName")String categoryName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using categoryDescription as a search criteria.
	 * 
	 * @param categoryDescription
	 * @return An Object ProductCategories whose categoryDescription is equals to the given categoryDescription. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.categoryDescription = :categoryDescription and e.isDeleted = :isDeleted")
	List<ProductCategories> findByCategoryDescription(@Param("categoryDescription")String categoryDescription, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object ProductCategories whose recordStatus is equals to the given recordStatus. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<ProductCategories> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object ProductCategories whose createdAt is equals to the given createdAt. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<ProductCategories> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object ProductCategories whose createdBy is equals to the given createdBy. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<ProductCategories> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object ProductCategories whose updatedAt is equals to the given updatedAt. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<ProductCategories> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object ProductCategories whose updatedBy is equals to the given updatedBy. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<ProductCategories> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object ProductCategories whose isDeleted is equals to the given isDeleted. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.isDeleted = :isDeleted")
	List<ProductCategories> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object ProductCategories whose deletedAt is equals to the given deletedAt. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<ProductCategories> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ProductCategories by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object ProductCategories whose deletedBy is equals to the given deletedBy. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<ProductCategories> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ProductCategories by using parentCategoryId as a search criteria.
	 * 
	 * @param parentCategoryId
	 * @return An Object ProductCategories whose parentCategoryId is equals to the given parentCategoryId. If
	 *         no ProductCategories is found, this method returns null.
	 */
	@Query("select e from ProductCategories e where e.productCategories.categoryId = :parentCategoryId and e.isDeleted = :isDeleted")
	List<ProductCategories> findByParentCategoryId(@Param("parentCategoryId")Integer parentCategoryId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of ProductCategories by using productCategoriesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of ProductCategories
	 * @throws DataAccessException,ParseException
	 */
	default List<ProductCategories> getByCriteria(Request<ProductCategoriesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from ProductCategories e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.categoryId desc";
		TypedQuery<ProductCategories> query = em.createQuery(req, ProductCategories.class);
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
	 * Finds count of ProductCategories by using productCategoriesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of ProductCategories
	 * 
	 */
	default Long count(Request<ProductCategoriesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from ProductCategories e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.categoryId desc";
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
	default String getWhereExpression(Request<ProductCategoriesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ProductCategoriesDto dto = request.getData() != null ? request.getData() : new ProductCategoriesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ProductCategoriesDto elt : request.getDatas()) {
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
	default String generateCriteria(ProductCategoriesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getCategoryId()!= null && dto.getCategoryId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("categoryId", dto.getCategoryId(), "e.categoryId", "Integer", dto.getCategoryIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCategoryName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("categoryName", dto.getCategoryName(), "e.categoryName", "String", dto.getCategoryNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCategoryDescription())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("categoryDescription", dto.getCategoryDescription(), "e.categoryDescription", "String", dto.getCategoryDescriptionParam(), param, index, locale));
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
			if (dto.getParentCategoryId()!= null && dto.getParentCategoryId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("parentCategoryId", dto.getParentCategoryId(), "e.productCategories.categoryId", "Integer", dto.getParentCategoryIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
