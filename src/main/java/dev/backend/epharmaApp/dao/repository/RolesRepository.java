package dev.backend.epharmaApp.dao.repository;

import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.dao.repository.customize._RolesRepository;
import dev.backend.epharmaApp.utils.CriteriaUtils;
import dev.backend.epharmaApp.utils.Utilities;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.dto.RolesDto;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.util.*;

/**
 * Repository : Roles.
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>, _RolesRepository {
	/**
	 * Finds Roles by using roleId as a search criteria.
	 * 
	 * @param roleId
	 * @return An Object Roles whose roleId is equals to the given roleId. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.roleId = :roleId and e.isDeleted = :isDeleted")
	Roles findOne(@Param("roleId")Integer roleId, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds Roles by using roleName as a search criteria.
	 * 
	 * @param roleName
	 * @return An Object Roles whose roleName is equals to the given roleName. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.roleName = :roleName and e.isDeleted = :isDeleted")
	List<Roles> findByRoleName(@Param("roleName")String roleName, @Param("isDeleted")Boolean isDeleted);

	@Query("select e from Roles e where e.roleName = :roleName and e.isDeleted = :isDeleted")
	Roles findByName(@Param("roleName")String roleName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using roleDescription as a search criteria.
	 * 
	 * @param roleDescription
	 * @return An Object Roles whose roleDescription is equals to the given roleDescription. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.roleDescription = :roleDescription and e.isDeleted = :isDeleted")
	List<Roles> findByRoleDescription(@Param("roleDescription")String roleDescription, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using recordStatus as a search criteria.
	 * 
	 * @param recordStatus
	 * @return An Object Roles whose recordStatus is equals to the given recordStatus. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.recordStatus = :recordStatus and e.isDeleted = :isDeleted")
	List<Roles> findByRecordStatus(@Param("recordStatus")String recordStatus, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object Roles whose createdAt is equals to the given createdAt. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<Roles> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using createdBy as a search criteria.
	 * 
	 * @param createdBy
	 * @return An Object Roles whose createdBy is equals to the given createdBy. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
	List<Roles> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object Roles whose updatedAt is equals to the given updatedAt. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<Roles> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using updatedBy as a search criteria.
	 * 
	 * @param updatedBy
	 * @return An Object Roles whose updatedBy is equals to the given updatedBy. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
	List<Roles> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object Roles whose isDeleted is equals to the given isDeleted. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.isDeleted = :isDeleted")
	List<Roles> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using deletedAt as a search criteria.
	 * 
	 * @param deletedAt
	 * @return An Object Roles whose deletedAt is equals to the given deletedAt. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
	List<Roles> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds Roles by using deletedBy as a search criteria.
	 * 
	 * @param deletedBy
	 * @return An Object Roles whose deletedBy is equals to the given deletedBy. If
	 *         no Roles is found, this method returns null.
	 */
	@Query("select e from Roles e where e.deletedBy = :deletedBy and e.isDeleted = :isDeleted")
	List<Roles> findByDeletedBy(@Param("deletedBy")Integer deletedBy, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of Roles by using rolesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Roles
	 * @throws DataAccessException,ParseException
	 */
	default List<Roles> getByCriteria(Request<RolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Roles e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.roleId desc";
		TypedQuery<Roles> query = em.createQuery(req, Roles.class);
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
	 * Finds count of Roles by using rolesDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Roles
	 * 
	 */
	default Long count(Request<RolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Roles e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.roleId desc";
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
	default String getWhereExpression(Request<RolesDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		RolesDto dto = request.getData() != null ? request.getData() : new RolesDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (RolesDto elt : request.getDatas()) {
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
	default String generateCriteria(RolesDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getRoleId()!= null && dto.getRoleId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("roleId", dto.getRoleId(), "e.roleId", "Integer", dto.getRoleIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getRoleName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("roleName", dto.getRoleName(), "e.roleName", "String", dto.getRoleNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getRoleDescription())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("roleDescription", dto.getRoleDescription(), "e.roleDescription", "String", dto.getRoleDescriptionParam(), param, index, locale));
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
