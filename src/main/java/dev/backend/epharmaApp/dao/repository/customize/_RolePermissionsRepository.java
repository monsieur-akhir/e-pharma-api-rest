package dev.backend.epharmaApp.dao.repository.customize;

import dev.backend.epharmaApp.dao.entity.RolePermissions;
import dev.backend.epharmaApp.utils.dto.RolePermissionsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Repository customize : RolePermissions.
 */
@Repository
public interface _RolePermissionsRepository {
	default List<String> _generateCriteria(RolePermissionsDto dto, HashMap<String, java.lang.Object> param, Integer index, Locale locale) throws Exception {
		List<String> listOfQuery = new ArrayList<String>();

		// PUT YOUR RIGHT CUSTOM CRITERIA HERE

		return listOfQuery;
	}

//	List<RolePermissions> findByRolesIdAndStatus(Integer roleId, String status);
	List<RolePermissions> findByRolesRoleIdAndRecordStatus(Integer roleId, String recordStatus);
	//List<RolePermissions> findByRolesIdAndPermissionsIdAndStatus(Integer roleId, Integer permissionId, String status);

}
