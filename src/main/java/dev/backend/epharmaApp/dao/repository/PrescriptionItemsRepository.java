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
import dev.backend.epharmaApp.dao.repository.customize._PrescriptionItemsRepository;

/**
 * Repository : PrescriptionItems.
 */
@Repository
public interface PrescriptionItemsRepository extends JpaRepository<PrescriptionItems, Integer>, _PrescriptionItemsRepository {
	/**
	 * Finds PrescriptionItems by using prescriptionItemId as a search criteria.
	 * 
	 * @param prescriptionItemId
	 * @return An Object PrescriptionItems whose prescriptionItemId is equals to the given prescriptionItemId. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.prescriptionItemId = :prescriptionItemId and e.isDeleted = :isDeleted")
	PrescriptionItems findOne(@Param("prescriptionItemId")Integer prescriptionItemId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PrescriptionItems by using dosage as a search criteria.
	 * 
	 * @param dosage
	 * @return An Object PrescriptionItems whose dosage is equals to the given dosage. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.dosage = :dosage and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByDosage(@Param("dosage")String dosage, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using frequency as a search criteria.
	 * 
	 * @param frequency
	 * @return An Object PrescriptionItems whose frequency is equals to the given frequency. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.frequency = :frequency and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByFrequency(@Param("frequency")String frequency, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using duration as a search criteria.
	 * 
	 * @param duration
	 * @return An Object PrescriptionItems whose duration is equals to the given duration. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.duration = :duration and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByDuration(@Param("duration")String duration, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using notes as a search criteria.
	 * 
	 * @param notes
	 * @return An Object PrescriptionItems whose notes is equals to the given notes. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.notes = :notes and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByNotes(@Param("notes")String notes, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object PrescriptionItems whose recordStatus is equals to the given recordStatus. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object PrescriptionItems whose createdAt is equals to the given createdAt. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object PrescriptionItems whose createdBy is equals to the given createdBy. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object PrescriptionItems whose updatedAt is equals to the given updatedAt. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object PrescriptionItems whose updatedBy is equals to the given updatedBy. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object PrescriptionItems whose isDeleted is equals to the given isDeleted. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object PrescriptionItems whose deletedAt is equals to the given deletedAt. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds PrescriptionItems by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object PrescriptionItems whose deletedBy is equals to the given deletedBy. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PrescriptionItems by using productId as a search criteria.
	 * 
	 * @param productId
	 * @return An Object PrescriptionItems whose productId is equals to the given productId. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.products.productId = :productId and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByProductId(@Param("productId")Integer productId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds PrescriptionItems by using prescriptionId as a search criteria.
	 * 
	 * @param prescriptionId
	 * @return An Object PrescriptionItems whose prescriptionId is equals to the given prescriptionId. If
	 *         no PrescriptionItems is found, this method returns null.
	 */
	@Query("select e from PrescriptionItems e where e.prescriptions.prescriptionId = :prescriptionId and e.isDeleted = :isDeleted")
	List<PrescriptionItems> findByPrescriptionId(@Param("prescriptionId")Integer prescriptionId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of PrescriptionItems by using prescriptionItemsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of PrescriptionItems
	 * @throws DataAccessException,ParseException
	 */
	default List<PrescriptionItems> getByCriteria(Request<PrescriptionItemsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from PrescriptionItems e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.prescriptionItemId desc";
		TypedQuery<PrescriptionItems> query = em.createQuery(req, PrescriptionItems.class);
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
	 * Finds count of PrescriptionItems by using prescriptionItemsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of PrescriptionItems
	 * 
	 */
	default Long count(Request<PrescriptionItemsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from PrescriptionItems e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.prescriptionItemId desc";
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
	default String getWhereExpression(Request<PrescriptionItemsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		PrescriptionItemsDto dto = request.getData() != null ? request.getData() : new PrescriptionItemsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (PrescriptionItemsDto elt : request.getDatas()) {
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
	default String generateCriteria(PrescriptionItemsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getPrescriptionItemId()!= null && dto.getPrescriptionItemId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("prescriptionItemId", dto.getPrescriptionItemId(), "e.prescriptionItemId", "Integer", dto.getPrescriptionItemIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDosage())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("dosage", dto.getDosage(), "e.dosage", "String", dto.getDosageParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFrequency())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("frequency", dto.getFrequency(), "e.frequency", "String", dto.getFrequencyParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDuration())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("duration", dto.getDuration(), "e.duration", "String", dto.getDurationParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getNotes())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("notes", dto.getNotes(), "e.notes", "String", dto.getNotesParam(), param, index, locale));
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
			if (dto.getPrescriptionId()!= null && dto.getPrescriptionId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("prescriptionId", dto.getPrescriptionId(), "e.prescriptions.prescriptionId", "Integer", dto.getPrescriptionIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
