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
import dev.backend.epharmaApp.dao.repository.customize._PermissionsRepository;

/**
 * Repository : Permissions.
 */
@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Integer>, _PermissionsRepository {
	/**
	 * Finds Permissions by using permissionId as a search criteria.
	 * 
	 * @param permissionId
	 * @return An Object Permissions whose permissionId is equals to the given permissionId. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.permissionId = :permissionId and e.isDeleted = :isDeleted")
	Permissions findOne(@Param("permissionId")Integer permissionId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Permissions by using permissionName as a search criteria.
	 * 
	 * @param permissionName
	 * @return An Object Permissions whose permissionName is equals to the given permissionName. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.permissionName = :permissionName and e.isDeleted = :isDeleted")
	List<Permissions> findByPermissionName(@Param("permissionName")String permissionName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using permissionDescription as a search criteria.
	 * 
	 * @param permissionDescription
	 * @return An Object Permissions whose permissionDescription is equals to the given permissionDescription. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.permissionDescription = :permissionDescription and e.isDeleted = :isDeleted")
	List<Permissions> findByPermissionDescription(@Param("permissionDescription")String permissionDescription, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Permissions whose recordStatus is equals to the given recordStatus. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Permissions> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Permissions whose createdAt is equals to the given createdAt. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Permissions> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Permissions whose createdBy is equals to the given createdBy. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Permissions> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Permissions whose updatedAt is equals to the given updatedAt. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Permissions> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Permissions whose updatedBy is equals to the given updatedBy. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Permissions> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Permissions whose isDeleted is equals to the given isDeleted. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.isDeleted = :isDeleted")
	List<Permissions> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Permissions whose deletedAt is equals to the given deletedAt. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Permissions> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Permissions by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Permissions whose deletedBy is equals to the given deletedBy. If
	 *         no Permissions is found, this method returns null.
	 */
	@Query("select e from Permissions e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Permissions> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Permissions by using permissionsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Permissions
	 * @throws DataAccessException,ParseException
	 */
	default List<Permissions> getByCriteria(Request<PermissionsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Permissions e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.permissionId desc";
		TypedQuery<Permissions> query = em.createQuery(req, Permissions.class);
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
	 * Finds count of Permissions by using permissionsDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Permissions
	 * 
	 */
	default Long count(Request<PermissionsDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Permissions e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.permissionId desc";
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
	default String getWhereExpression(Request<PermissionsDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		PermissionsDto dto = request.getData() != null ? request.getData() : new PermissionsDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (PermissionsDto elt : request.getDatas()) {
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
	default String generateCriteria(PermissionsDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getPermissionId()!= null && dto.getPermissionId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("permissionId", dto.getPermissionId(), "e.permissionId", "Integer", dto.getPermissionIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPermissionName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("permissionName", dto.getPermissionName(), "e.permissionName", "String", dto.getPermissionNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPermissionDescription())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("permissionDescription", dto.getPermissionDescription(), "e.permissionDescription", "String", dto.getPermissionDescriptionParam(), param, index, locale));
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
