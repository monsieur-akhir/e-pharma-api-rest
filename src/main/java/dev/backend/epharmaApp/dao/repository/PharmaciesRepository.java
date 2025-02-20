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
import dev.backend.epharmaApp.dao.repository.customize._PharmaciesRepository;

/**
 * Repository : Pharmacies.
 */
@Repository
public interface PharmaciesRepository extends JpaRepository<Pharmacies, Integer>, _PharmaciesRepository {
	/**
	 * Finds Pharmacies by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object Pharmacies whose pharmacyId is equals to the given pharmacyId. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	Pharmacies findOne(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Pharmacies by using pharmacyName as a search criteria.
	 * 
	 * @param pharmacyName
	 * @return An Object Pharmacies whose pharmacyName is equals to the given pharmacyName. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.pharmacyName = :pharmacyName and e.isDeleted = :isDeleted")
	List<Pharmacies> findByPharmacyName(@Param("pharmacyName")String pharmacyName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using address as a search criteria.
	 * 
	 * @param address
	 * @return An Object Pharmacies whose address is equals to the given address. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.address = :address and e.isDeleted = :isDeleted")
	List<Pharmacies> findByAddress(@Param("address")String address, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using city as a search criteria.
	 * 
	 * @param city
	 * @return An Object Pharmacies whose city is equals to the given city. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.city = :city and e.isDeleted = :isDeleted")
	List<Pharmacies> findByCity(@Param("city")String city, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using country as a search criteria.
	 * 
	 * @param country
	 * @return An Object Pharmacies whose country is equals to the given country. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.country = :country and e.isDeleted = :isDeleted")
	List<Pharmacies> findByCountry(@Param("country")String country, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using phone as a search criteria.
	 * 
	 * @param phone
	 * @return An Object Pharmacies whose phone is equals to the given phone. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.phone = :phone and e.isDeleted = :isDeleted")
	List<Pharmacies> findByPhone(@Param("phone")String phone, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using location as a search criteria.
	 * 
	 * @param location
	 * @return An Object Pharmacies whose location is equals to the given location. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.location = :location and e.isDeleted = :isDeleted")
	List<Pharmacies> findByLocation(@Param("location")byte[] location, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using logo as a search criteria.
	 * 
	 * @param logo
	 * @return An Object Pharmacies whose logo is equals to the given logo. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.logo = :logo and e.isDeleted = :isDeleted")
	List<Pharmacies> findByLogo(@Param("logo")String logo, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using autorisation as a search criteria.
	 * 
	 * @param autorisation
	 * @return An Object Pharmacies whose autorisation is equals to the given autorisation. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.autorisation = :autorisation and e.isDeleted = :isDeleted")
	List<Pharmacies> findByAutorisation(@Param("autorisation")String autorisation, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Pharmacies whose recordStatus is equals to the given recordStatus. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Pharmacies> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Pharmacies whose createdAt is equals to the given createdAt. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Pharmacies> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Pharmacies whose createdBy is equals to the given createdBy. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Pharmacies> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Pharmacies whose updatedAt is equals to the given updatedAt. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Pharmacies> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Pharmacies whose updatedBy is equals to the given updatedBy. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Pharmacies> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Pharmacies whose isDeleted is equals to the given isDeleted. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.isDeleted = :isDeleted")
	List<Pharmacies> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Pharmacies whose deletedAt is equals to the given deletedAt. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Pharmacies> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Pharmacies by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Pharmacies whose deletedBy is equals to the given deletedBy. If
	 *         no Pharmacies is found, this method returns null.
	 */
	@Query("select e from Pharmacies e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Pharmacies> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Pharmacies by using pharmaciesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Pharmacies
	 * @throws DataAccessException,ParseException
	 */
	default List<Pharmacies> getByCriteria(Request<PharmaciesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Pharmacies e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.pharmacyId desc";
		TypedQuery<Pharmacies> query = em.createQuery(req, Pharmacies.class);
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
	 * Finds count of Pharmacies by using pharmaciesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Pharmacies
	 * 
	 */
	default Long count(Request<PharmaciesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Pharmacies e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.pharmacyId desc";
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
	default String getWhereExpression(Request<PharmaciesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		PharmaciesDto dto = request.getData() != null ? request.getData() : new PharmaciesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (PharmaciesDto elt : request.getDatas()) {
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
	default String generateCriteria(PharmaciesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getPharmacyId()!= null && dto.getPharmacyId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("pharmacyId", dto.getPharmacyId(), "e.pharmacyId", "Integer", dto.getPharmacyIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPharmacyName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("pharmacyName", dto.getPharmacyName(), "e.pharmacyName", "String", dto.getPharmacyNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getAddress())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("address", dto.getAddress(), "e.address", "String", dto.getAddressParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCity())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("city", dto.getCity(), "e.city", "String", dto.getCityParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCountry())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("country", dto.getCountry(), "e.country", "String", dto.getCountryParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPhone())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("phone", dto.getPhone(), "e.phone", "String", dto.getPhoneParam(), param, index, locale));
			}
			if (dto.getLocation()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("location", dto.getLocation(), "e.location", "byte[]", dto.getLocationParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLogo())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("logo", dto.getLogo(), "e.logo", "String", dto.getLogoParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getAutorisation())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("autorisation", dto.getAutorisation(), "e.autorisation", "String", dto.getAutorisationParam(), param, index, locale));
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
