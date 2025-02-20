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
import dev.backend.epharmaApp.dao.repository.customize._DeliveriesRepository;

/**
 * Repository : Deliveries.
 */
@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, Integer>, _DeliveriesRepository {
	/**
	 * Finds Deliveries by using deliveryId as a search criteria.
	 * 
	 * @param deliveryId
	 * @return An Object Deliveries whose deliveryId is equals to the given deliveryId. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.deliveryId = :deliveryId and e.isDeleted = :isDeleted")
	Deliveries findOne(@Param("deliveryId")Integer deliveryId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Deliveries by using deliveryStatus as a search criteria.
	 * 
	 * @param deliveryStatus
	 * @return An Object Deliveries whose deliveryStatus is equals to the given deliveryStatus. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.deliveryStatus = :deliveryStatus and e.isDeleted = :isDeleted")
	List<Deliveries> findByDeliveryStatus(@Param("deliveryStatus")String deliveryStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using expectedDeliveryDate as a search criteria.
	 * 
	 * @param expectedDeliveryDate
	 * @return An Object Deliveries whose expectedDeliveryDate is equals to the given expectedDeliveryDate. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.expectedDeliveryDate = :expectedDeliveryDate and e.isDeleted = :isDeleted")
	List<Deliveries> findByExpectedDeliveryDate(@Param("expectedDeliveryDate")Date expectedDeliveryDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using actualDeliveryDate as a search criteria.
	 * 
	 * @param actualDeliveryDate
	 * @return An Object Deliveries whose actualDeliveryDate is equals to the given actualDeliveryDate. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.actualDeliveryDate = :actualDeliveryDate and e.isDeleted = :isDeleted")
	List<Deliveries> findByActualDeliveryDate(@Param("actualDeliveryDate")Date actualDeliveryDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using trackingNumber as a search criteria.
	 * 
	 * @param trackingNumber
	 * @return An Object Deliveries whose trackingNumber is equals to the given trackingNumber. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.trackingNumber = :trackingNumber and e.isDeleted = :isDeleted")
	List<Deliveries> findByTrackingNumber(@Param("trackingNumber")String trackingNumber, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using deliveryMethod as a search criteria.
	 * 
	 * @param deliveryMethod
	 * @return An Object Deliveries whose deliveryMethod is equals to the given deliveryMethod. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.deliveryMethod = :deliveryMethod and e.isDeleted = :isDeleted")
	List<Deliveries> findByDeliveryMethod(@Param("deliveryMethod")String deliveryMethod, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Deliveries whose recordStatus is equals to the given recordStatus. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Deliveries> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Deliveries whose createdAt is equals to the given createdAt. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Deliveries> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Deliveries whose createdBy is equals to the given createdBy. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Deliveries> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Deliveries whose updatedAt is equals to the given updatedAt. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Deliveries> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Deliveries whose updatedBy is equals to the given updatedBy. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Deliveries> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Deliveries whose isDeleted is equals to the given isDeleted. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.isDeleted = :isDeleted")
	List<Deliveries> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Deliveries whose deletedAt is equals to the given deletedAt. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Deliveries> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Deliveries by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Deliveries whose deletedBy is equals to the given deletedBy. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Deliveries> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Deliveries by using orderId as a search criteria.
	 * 
	 * @param orderId
	 * @return An Object Deliveries whose orderId is equals to the given orderId. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.orders.orderId = :orderId and e.isDeleted = :isDeleted")
	List<Deliveries> findByOrderId(@Param("orderId")Integer orderId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Deliveries by using pharmacyId as a search criteria.
	 * 
	 * @param pharmacyId
	 * @return An Object Deliveries whose pharmacyId is equals to the given pharmacyId. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.pharmacies.pharmacyId = :pharmacyId and e.isDeleted = :isDeleted")
	List<Deliveries> findByPharmacyId(@Param("pharmacyId")Integer pharmacyId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Deliveries by using assignedTo as a search criteria.
	 * 
	 * @param assignedTo
	 * @return An Object Deliveries whose assignedTo is equals to the given assignedTo. If
	 *         no Deliveries is found, this method returns null.
	 */
	@Query("select e from Deliveries e where e.users.userId = :assignedTo and e.isDeleted = :isDeleted")
	List<Deliveries> findByAssignedTo(@Param("assignedTo")Integer assignedTo, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Deliveries by using deliveriesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Deliveries
	 * @throws DataAccessException,ParseException
	 */
	default List<Deliveries> getByCriteria(Request<DeliveriesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Deliveries e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.deliveryId desc";
		TypedQuery<Deliveries> query = em.createQuery(req, Deliveries.class);
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
	 * Finds count of Deliveries by using deliveriesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Deliveries
	 * 
	 */
	default Long count(Request<DeliveriesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Deliveries e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.deliveryId desc";
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
	default String getWhereExpression(Request<DeliveriesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		DeliveriesDto dto = request.getData() != null ? request.getData() : new DeliveriesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (DeliveriesDto elt : request.getDatas()) {
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
	default String generateCriteria(DeliveriesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getDeliveryId()!= null && dto.getDeliveryId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("deliveryId", dto.getDeliveryId(), "e.deliveryId", "Integer", dto.getDeliveryIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDeliveryStatus())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("deliveryStatus", dto.getDeliveryStatus(), "e.deliveryStatus", "String", dto.getDeliveryStatusParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getExpectedDeliveryDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("expectedDeliveryDate", dto.getExpectedDeliveryDate(), "e.expectedDeliveryDate", "Date", dto.getExpectedDeliveryDateParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getActualDeliveryDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("actualDeliveryDate", dto.getActualDeliveryDate(), "e.actualDeliveryDate", "Date", dto.getActualDeliveryDateParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getTrackingNumber())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("trackingNumber", dto.getTrackingNumber(), "e.trackingNumber", "String", dto.getTrackingNumberParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDeliveryMethod())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("deliveryMethod", dto.getDeliveryMethod(), "e.deliveryMethod", "String", dto.getDeliveryMethodParam(), param, index, locale));
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
			if (dto.getOrderId()!= null && dto.getOrderId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("orderId", dto.getOrderId(), "e.orders.orderId", "Integer", dto.getOrderIdParam(), param, index, locale));
			}
			if (dto.getPharmacyId()!= null && dto.getPharmacyId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("pharmacyId", dto.getPharmacyId(), "e.pharmacies.pharmacyId", "Integer", dto.getPharmacyIdParam(), param, index, locale));
			}
			if (dto.getAssignedTo()!= null && dto.getAssignedTo() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("assignedTo", dto.getAssignedTo(), "e.users.userId", "Integer", dto.getAssignedToParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersLogin())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersLogin", dto.getUsersLogin(), "e.users.login", "String", dto.getUsersLoginParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersFirstName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersFirstName", dto.getUsersFirstName(), "e.users.firstName", "String", dto.getUsersFirstNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUsersLastName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("usersLastName", dto.getUsersLastName(), "e.users.lastName", "String", dto.getUsersLastNameParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
