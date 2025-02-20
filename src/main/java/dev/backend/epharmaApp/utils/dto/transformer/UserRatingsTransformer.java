

/*
 * Java transformer for entity table user_ratings 
 * Created on 2025-02-15 ( Time 03:02:47 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.UserRatings;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.UserRatingsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "user_ratings"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UserRatingsTransformer {

	UserRatingsTransformer INSTANCE = Mappers.getMapper(UserRatingsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.users.userId", target="ratedUserId"),
		@Mapping(source="entity.users.login", target="usersLogin"),
		@Mapping(source="entity.users.firstName", target="usersFirstName"),
		@Mapping(source="entity.users.lastName", target="usersLastName"),
		@Mapping(source="entity.users2.userId", target="raterId"),
		@Mapping(source="entity.users2.login", target="users2Login"),
		@Mapping(source="entity.users2.firstName", target="users2FirstName"),
		@Mapping(source="entity.users2.lastName", target="users2LastName"),
	})
	UserRatingsDto toDto(UserRatings entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UserRatingsDto> toDtos(List<UserRatings> entities) throws ParseException;

    default UserRatingsDto toLiteDto(UserRatings entity) {
		if (entity == null) {
			return null;
		}
		UserRatingsDto dto = new UserRatingsDto();
		dto.setRatingId( entity.getRatingId() );
		return dto;
    }

	default List<UserRatingsDto> toLiteDtos(List<UserRatings> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UserRatingsDto> dtos = new ArrayList<UserRatingsDto>();
		for (UserRatings entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.ratingId", target="ratingId"),
		@Mapping(source="dto.ratingValue", target="ratingValue"),
		@Mapping(source="dto.comment", target="comment"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="users", target="users"),
		@Mapping(source="users2", target="users2"),
	})
    UserRatings toEntity(UserRatingsDto dto, Users users, Users users2) throws ParseException;

    //List<UserRatings> toEntities(List<UserRatingsDto> dtos) throws ParseException;

}
