package dev.backend.epharmaApp.dao.repository.customize;

import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.UsersDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Repository customize : Users.
 */
@Repository
public interface _UsersRepository {
	default List<String> _generateCriteria(UsersDto dto, HashMap<String, java.lang.Object> param, Integer index, Locale locale) throws Exception {
		List<String> listOfQuery = new ArrayList<String>();

		// PUT YOUR RIGHT CUSTOM CRITERIA HERE

		return listOfQuery;
	}

	@Query("SELECT u FROM Users u WHERE (u.email = :emailOrPhone OR u.phone = :emailOrPhone) AND u.isDeleted = false")
	Users findByEmailOrPhone(@Param("emailOrPhone") String emailOrPhone);

}
