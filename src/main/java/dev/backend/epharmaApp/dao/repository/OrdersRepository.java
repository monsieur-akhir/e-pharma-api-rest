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
import dev.backend.epharmaApp.dao.repository.customize._OrdersRepository;

/**
 * Repository : Orders.
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>, _OrdersRepository {
	/**
	 * Finds Orders by using orderId as a search criteria.
	 * 
	 * @param orderId
	 * @return An Object Orders whose orderId is equals to the given orderId. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.orderId = :orderId and e.isDeleted = :isDeleted")
	Orders findOne(@Param("orderId")Integer orderId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Orders by using orderDate as a search criteria.
	 * 
	 * @param orderDate
	 * @return An Object Orders whose orderDate is equals to the given orderDate. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.orderDate = :orderDate and e.isDeleted = :isDeleted")
	List<Orders> findByOrderDate(@Param("orderDate")Date orderDate, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using orderStatus as a search criteria.
	 * 
	 * @param orderStatus
	 * @return An Object Orders whose orderStatus is equals to the given orderStatus. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.orderStatus = :orderStatus and e.isDeleted = :isDeleted")
	List<Orders> findByOrderStatus(@Param("orderStatus")String orderStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using totalAmount as a search criteria.
	 * 
	 * @param totalAmount
	 * @return An Object Orders whose totalAmount is equals to the given totalAmount. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.totalAmount = :totalAmount and e.isDeleted = :isDeleted")
	List<Orders> findByTotalAmount(@Param("totalAmount")BigDecimal totalAmount, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using paymentMethod as a search criteria.
	 * 
	 * @param paymentMethod
	 * @return An Object Orders whose paymentMethod is equals to the given paymentMethod. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.paymentMethod = :paymentMethod and e.isDeleted = :isDeleted")
	List<Orders> findByPaymentMethod(@Param("paymentMethod")String paymentMethod, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Orders whose recordStatus is equals to the given recordStatus. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Orders> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Orders whose createdAt is equals to the given createdAt. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Orders> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Orders whose createdBy is equals to the given createdBy. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Orders> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Orders whose updatedAt is equals to the given updatedAt. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Orders> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Orders whose updatedBy is equals to the given updatedBy. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Orders> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Orders whose isDeleted is equals to the given isDeleted. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.isDeleted = :isDeleted")
	List<Orders> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Orders whose deletedAt is equals to the given deletedAt. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Orders> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Orders by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Orders whose deletedBy is equals to the given deletedBy. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Orders> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Orders by using clientId as a search criteria.
	 * 
	 * @param clientId
	 * @return An Object Orders whose clientId is equals to the given clientId. If
	 *         no Orders is found, this method returns null.
	 */
	@Query("select e from Orders e where e.clients.clientId = :clientId and e.isDeleted = :isDeleted")
	List<Orders> findByClientId(@Param("clientId")Integer clientId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Orders by using ordersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Orders
	 * @throws DataAccessException,ParseException
	 */
	default List<Orders> getByCriteria(Request<OrdersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Orders e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.orderId desc";
		TypedQuery<Orders> query = em.createQuery(req, Orders.class);
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
	 * Finds count of Orders by using ordersDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Orders
	 * 
	 */
	default Long count(Request<OrdersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Orders e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.orderId desc";
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
	default String getWhereExpression(Request<OrdersDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		OrdersDto dto = request.getData() != null ? request.getData() : new OrdersDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (OrdersDto elt : request.getDatas()) {
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
	default String generateCriteria(OrdersDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getOrderId()!= null && dto.getOrderId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("orderId", dto.getOrderId(), "e.orderId", "Integer", dto.getOrderIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getOrderDate())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("orderDate", dto.getOrderDate(), "e.orderDate", "Date", dto.getOrderDateParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getOrderStatus())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("orderStatus", dto.getOrderStatus(), "e.orderStatus", "String", dto.getOrderStatusParam(), param, index, locale));
			}
			if (dto.getTotalAmount()!= null && dto.getTotalAmount().intValue() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("totalAmount", dto.getTotalAmount(), "e.totalAmount", "BigDecimal", dto.getTotalAmountParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPaymentMethod())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("paymentMethod", dto.getPaymentMethod(), "e.paymentMethod", "String", dto.getPaymentMethodParam(), param, index, locale));
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
