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
import dev.backend.epharmaApp.dao.entity.RolePermissionsKey;
import dev.backend.epharmaApp.dao.repository.customize._RolePermissionsRepository;

/**
 * Repository : RolePermissions.
 */
@Repository
public interface RolePermissionsRepository extends JpaRepository<RolePermissions, RolePermissionsKey>, _RolePermissionsRepository {
	/**
	 * Finds RolePermissions by using roleId as a search criteria.
	 * 
	 * @param roleId
	 * @return An Object RolePermissions whose roleId is equals to the given roleId. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.roles.roleId = :roleId and e.isDeleted = :isDeleted")
	RolePermissions findOne(@Param("roleId")Integer roleId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds RolePermissions by using permissionId as a search criteria.
	 * 
	 * @param permissionId
	 * @return An Object RolePermissions whose permissionId is equals to the given permissionId. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.permissions.permissionId = :permissionId and e.isDeleted = :isDeleted")
	RolePermissions findOne2(@Param("permissionId")Integer permissionId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds RolePermissions by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object RolePermissions whose recordStatus is equals to the given recordStatus. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<RolePermissions> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds RolePermissions by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object RolePermissions whose createdAt is equals to the given createdAt. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<RolePermissions> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds RolePermissions by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object RolePermissions whose createdBy is equals to the given createdBy. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<RolePermissions> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds RolePermissions by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object RolePermissions whose updatedAt is equals to the given updatedAt. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<RolePermissions> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds RolePermissions by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object RolePermissions whose updatedBy is equals to the given updatedBy. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<RolePermissions> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds RolePermissions by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object RolePermissions whose isDeleted is equals to the given isDeleted. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.isDeleted = :isDeleted")
	List<RolePermissions> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds RolePermissions by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object RolePermissions whose deletedAt is equals to the given deletedAt. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<RolePermissions> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds RolePermissions by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object RolePermissions whose deletedBy is equals to the given deletedBy. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<RolePermissions> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds RolePermissions by using roleId as a search criteria.
	 * 
	 * @param roleId
	 * @return An Object RolePermissions whose roleId is equals to the given roleId. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.roles.roleId = :roleId and e.isDeleted = :isDeleted")
	List<RolePermissions> findByRoleId(@Param("roleId")Integer roleId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds RolePermissions by using permissionId as a search criteria.
	 * 
	 * @param permissionId
	 * @return An Object RolePermissions whose permissionId is equals to the given permissionId. If
	 *         no RolePermissions is found, this method returns null.
	 */
	@Query("select e from RolePermissions e where e.permissions.permissionId = :permissionId and e.isDeleted = :isDeleted")
	List<RolePermissions> findByPermissionId(@Param("permissionId")Integer permissionId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of RolePermissions by using rolePermissionsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of RolePermissions
	 * @throws DataAccessException,ParseException
	 */
	default List<RolePermissions> getByCriteria(Request<RolePermissionsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from RolePermissions e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.roleIde.permissionId desc";
		TypedQuery<RolePermissions> query = em.createQuery(req, RolePermissions.class);
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
	 * Finds count of RolePermissions by using rolePermissionsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of RolePermissions
	 * 
	 */
	default Long count(Request<RolePermissionsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from RolePermissions e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.roleId e.permissionId desc";
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
	default String getWhereExpression(Request<RolePermissionsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		RolePermissionsDto dto = request.getData() != null ? request.getData() : new RolePermissionsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (RolePermissionsDto elt : request.getDatas()) {
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
	default String generateCriteria(RolePermissionsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
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
			if (dto.getPermissionId()!= null && dto.getPermissionId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("permissionId", dto.getPermissionId(), "e.permissions.permissionId", "Integer", dto.getPermissionIdParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
