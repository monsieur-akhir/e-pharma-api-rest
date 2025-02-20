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
import dev.backend.epharmaApp.dao.entity.ClientRolesKey;
import dev.backend.epharmaApp.dao.repository.customize._ClientRolesRepository;

/**
 * Repository : ClientRoles.
 */
@Repository
public interface ClientRolesRepository extends JpaRepository<ClientRoles, ClientRolesKey>, _ClientRolesRepository {
	/**
	 * Finds ClientRoles by using clientId as a search criteria.
	 * 
	 * @param clientId
	 * @return An Object ClientRoles whose clientId is equals to the given clientId. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.clients.clientId = :clientId and e.isDeleted = :isDeleted")
	ClientRoles findOneByClientId(@Param("clientId")Integer clientId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ClientRoles by using roleId as a search criteria.
	 * 
	 * @param roleId
	 * @return An Object ClientRoles whose roleId is equals to the given roleId. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.roles.roleId = :roleId and e.isDeleted = :isDeleted")
	ClientRoles findOneByRoleId(@Param("roleId")Integer roleId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ClientRoles by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object ClientRoles whose recordStatus is equals to the given recordStatus. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<ClientRoles> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ClientRoles by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object ClientRoles whose createdAt is equals to the given createdAt. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<ClientRoles> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ClientRoles by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object ClientRoles whose createdBy is equals to the given createdBy. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<ClientRoles> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ClientRoles by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object ClientRoles whose updatedAt is equals to the given updatedAt. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<ClientRoles> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ClientRoles by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object ClientRoles whose updatedBy is equals to the given updatedBy. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<ClientRoles> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ClientRoles by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object ClientRoles whose isDeleted is equals to the given isDeleted. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.isDeleted = :isDeleted")
	List<ClientRoles> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ClientRoles by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object ClientRoles whose deletedAt is equals to the given deletedAt. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<ClientRoles> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds ClientRoles by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object ClientRoles whose deletedBy is equals to the given deletedBy. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<ClientRoles> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ClientRoles by using roleId as a search criteria.
	 * 
	 * @param roleId
	 * @return An Object ClientRoles whose roleId is equals to the given roleId. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.roles.roleId = :roleId and e.isDeleted = :isDeleted")
	List<ClientRoles> findByRoleId(@Param("roleId")Integer roleId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds ClientRoles by using clientId as a search criteria.
	 * 
	 * @param clientId
	 * @return An Object ClientRoles whose clientId is equals to the given clientId. If
	 *         no ClientRoles is found, this method returns null.
	 */
	@Query("select e from ClientRoles e where e.clients.clientId = :clientId and e.isDeleted = :isDeleted")
	List<ClientRoles> findByClientId(@Param("clientId")Integer clientId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of ClientRoles by using clientRolesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of ClientRoles
	 * @throws DataAccessException,ParseException
	 */
	default List<ClientRoles> getByCriteria(Request<ClientRolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from ClientRoles e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.clientIde.roleId desc";
		TypedQuery<ClientRoles> query = em.createQuery(req, ClientRoles.class);
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
	 * Finds count of ClientRoles by using clientRolesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of ClientRoles
	 * 
	 */
	default Long count(Request<ClientRolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from ClientRoles e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.clientId e.roleId desc";
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
	default String getWhereExpression(Request<ClientRolesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		ClientRolesDto dto = request.getData() != null ? request.getData() : new ClientRolesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (ClientRolesDto elt : request.getDatas()) {
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
	default String generateCriteria(ClientRolesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
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
			if (dto.getRoleId()!= null && dto.getRoleId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("roleId", dto.getRoleId(), "e.roles.roleId", "Integer", dto.getRoleIdParam(), param, index, locale));
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
