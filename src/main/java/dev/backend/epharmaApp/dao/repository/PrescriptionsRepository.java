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
import dev.backend.epharmaApp.dao.repository.customize._PrescriptionsRepository;

/**
 * Repository : Prescriptions.
 */
@Repository
public interface PrescriptionsRepository extends JpaRepository<Prescriptions, Integer>, _PrescriptionsRepository {
	/**
	 * Finds Prescriptions by using prescriptionId as a search criteria.
	 * 
	 * @param prescriptionId
	 * @return An Object Prescriptions whose prescriptionId is equals to the given prescriptionId. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.prescriptionId = :prescriptionId and e.isDeleted = :isDeleted")
	Prescriptions findOne(@Param("prescriptionId")Integer prescriptionId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Prescriptions by using prescribingDoctor as a search criteria.
	 * 
	 * @param prescribingDoctor
	 * @return An Object Prescriptions whose prescribingDoctor is equals to the given prescribingDoctor. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.prescribingDoctor = :prescribingDoctor and e.isDeleted = :isDeleted")
	List<Prescriptions> findByPrescribingDoctor(@Param("prescribingDoctor")String prescribingDoctor, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using dateIssued as a search criteria.
	 * 
	 * @param dateIssued
	 * @return An Object Prescriptions whose dateIssued is equals to the given dateIssued. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.dateIssued = :dateIssued and e.isDeleted = :isDeleted")
	List<Prescriptions> findByDateIssued(@Param("dateIssued")Date dateIssued, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using dateExpiration as a search criteria.
	 * 
	 * @param dateExpiration
	 * @return An Object Prescriptions whose dateExpiration is equals to the given dateExpiration. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.dateExpiration = :dateExpiration and e.isDeleted = :isDeleted")
	List<Prescriptions> findByDateExpiration(@Param("dateExpiration")Date dateExpiration, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Prescriptions whose recordStatus is equals to the given recordStatus. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Prescriptions> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Prescriptions whose createdAt is equals to the given createdAt. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Prescriptions> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Prescriptions whose createdBy is equals to the given createdBy. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Prescriptions> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Prescriptions whose updatedAt is equals to the given updatedAt. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Prescriptions> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Prescriptions whose updatedBy is equals to the given updatedBy. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Prescriptions> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Prescriptions whose isDeleted is equals to the given isDeleted. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.isDeleted = :isDeleted")
	List<Prescriptions> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Prescriptions whose deletedAt is equals to the given deletedAt. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Prescriptions> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Prescriptions by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Prescriptions whose deletedBy is equals to the given deletedBy. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Prescriptions> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Prescriptions by using clientId as a search criteria.
	 * 
	 * @param clientId
	 * @return An Object Prescriptions whose clientId is equals to the given clientId. If
	 *         no Prescriptions is found, this method returns null.
	 */
	@Query("select e from Prescriptions e where e.clients.clientId = :clientId and e.isDeleted = :isDeleted")
	List<Prescriptions> findByClientId(@Param("clientId")Integer clientId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Prescriptions by using prescriptionsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Prescriptions
	 * @throws DataAccessException,ParseException
	 */
	default List<Prescriptions> getByCriteria(Request<PrescriptionsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Prescriptions e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.prescriptionId desc";
		TypedQuery<Prescriptions> query = em.createQuery(req, Prescriptions.class);
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
	 * Finds count of Prescriptions by using prescriptionsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Prescriptions
	 * 
	 */
	default Long count(Request<PrescriptionsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Prescriptions e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.prescriptionId desc";
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
	default String getWhereExpression(Request<PrescriptionsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		PrescriptionsDto dto = request.getData() != null ? request.getData() : new PrescriptionsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (PrescriptionsDto elt : request.getDatas()) {
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
	default String generateCriteria(PrescriptionsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getPrescriptionId()!= null && dto.getPrescriptionId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("prescriptionId", dto.getPrescriptionId(), "e.prescriptionId", "Integer", dto.getPrescriptionIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPrescribingDoctor())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("prescribingDoctor", dto.getPrescribingDoctor(), "e.prescribingDoctor", "String", dto.getPrescribingDoctorParam(), param, index, locale));
			}
			if (dto.getDateIssued()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("dateIssued", dto.getDateIssued(), "e.dateIssued", "Date", dto.getDateIssuedParam(), param, index, locale));
			}
			if (dto.getDateExpiration()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("dateExpiration", dto.getDateExpiration(), "e.dateExpiration", "Date", dto.getDateExpirationParam(), param, index, locale));
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
			if (dto.getClientId()!= null && dto.getClientId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("clientId", dto.getClientId(), "e.clients.clientId", "Integer", dto.getClientIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getClientsFirstName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("clientsFirstName", dto.getClientsFirstName(), "e.clients.firstName", "String", dto.getClientsFirstNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getClientsLastName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("clientsLastName", dto.getClientsLastName(), "e.clients.lastName", "String", dto.getClientsLastNameParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
