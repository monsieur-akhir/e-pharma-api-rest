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
import dev.backend.epharmaApp.dao.repository.customize._ManufacturersRepository;

/**
 * Repository : Manufacturers.
 */
@Repository
public interface ManufacturersRepository extends JpaRepository<Manufacturers, Integer>, _ManufacturersRepository {
	/**
	 * Finds Manufacturers by using manufacturerId as a search criteria.
	 * 
	 * @param manufacturerId
	 * @return An Object Manufacturers whose manufacturerId is equals to the given manufacturerId. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.manufacturerId = :manufacturerId and e.isDeleted = :isDeleted")
	Manufacturers findOne(@Param("manufacturerId")Integer manufacturerId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Manufacturers by using manufacturerName as a search criteria.
	 * 
	 * @param manufacturerName
	 * @return An Object Manufacturers whose manufacturerName is equals to the given manufacturerName. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.manufacturerName = :manufacturerName and e.isDeleted = :isDeleted")
	List<Manufacturers> findByManufacturerName(@Param("manufacturerName")String manufacturerName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using contactEmail as a search criteria.
	 * 
	 * @param contactEmail
	 * @return An Object Manufacturers whose contactEmail is equals to the given contactEmail. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.contactEmail = :contactEmail and e.isDeleted = :isDeleted")
	List<Manufacturers> findByContactEmail(@Param("contactEmail")String contactEmail, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using phone as a search criteria.
	 * 
	 * @param phone
	 * @return An Object Manufacturers whose phone is equals to the given phone. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.phone = :phone and e.isDeleted = :isDeleted")
	List<Manufacturers> findByPhone(@Param("phone")String phone, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using address as a search criteria.
	 * 
	 * @param address
	 * @return An Object Manufacturers whose address is equals to the given address. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.address = :address and e.isDeleted = :isDeleted")
	List<Manufacturers> findByAddress(@Param("address")String address, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Manufacturers whose recordStatus is equals to the given recordStatus. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Manufacturers> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Manufacturers whose createdAt is equals to the given createdAt. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Manufacturers> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Manufacturers whose createdBy is equals to the given createdBy. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Manufacturers> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Manufacturers whose updatedAt is equals to the given updatedAt. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Manufacturers> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Manufacturers whose updatedBy is equals to the given updatedBy. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Manufacturers> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Manufacturers whose isDeleted is equals to the given isDeleted. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.isDeleted = :isDeleted")
	List<Manufacturers> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Manufacturers whose deletedAt is equals to the given deletedAt. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Manufacturers> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Manufacturers by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Manufacturers whose deletedBy is equals to the given deletedBy. If
	 *         no Manufacturers is found, this method returns null.
	 */
	@Query("select e from Manufacturers e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Manufacturers> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Manufacturers by using manufacturersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Manufacturers
	 * @throws DataAccessException,ParseException
	 */
	default List<Manufacturers> getByCriteria(Request<ManufacturersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Manufacturers e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.manufacturerId desc";
		TypedQuery<Manufacturers> query = em.createQuery(req, Manufacturers.class);
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
	 * Finds count of Manufacturers by using manufacturersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Manufacturers
	 * 
	 */
	default Long count(Request<ManufacturersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Manufacturers e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.manufacturerId desc";
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
	default String getWhereExpression(Request<ManufacturersDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ManufacturersDto dto = request.getData() != null ? request.getData() : new ManufacturersDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ManufacturersDto elt : request.getDatas()) {
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
	default String generateCriteria(ManufacturersDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getManufacturerId()!= null && dto.getManufacturerId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("manufacturerId", dto.getManufacturerId(), "e.manufacturerId", "Integer", dto.getManufacturerIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getManufacturerName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("manufacturerName", dto.getManufacturerName(), "e.manufacturerName", "String", dto.getManufacturerNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getContactEmail())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("contactEmail", dto.getContactEmail(), "e.contactEmail", "String", dto.getContactEmailParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPhone())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("phone", dto.getPhone(), "e.phone", "String", dto.getPhoneParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getAddress())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("address", dto.getAddress(), "e.address", "String", dto.getAddressParam(), param, index, locale));
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
