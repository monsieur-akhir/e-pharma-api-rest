

/*
 * Java transformer for entity table chat_room_participants 
 * Created on 2025-02-15 ( Time 03:02:40 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ChatRoomParticipants;
import dev.backend.epharmaApp.dao.entity.ChatRooms;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.ChatRoomParticipantsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "chat_room_participants"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ChatRoomParticipantsTransformer {

	ChatRoomParticipantsTransformer INSTANCE = Mappers.getMapper(ChatRoomParticipantsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.users.userId", target="userId"),
		@Mapping(source="entity.users.login", target="usersLogin"),
		@Mapping(source="entity.users.firstName", target="usersFirstName"),
		@Mapping(source="entity.users.lastName", target="usersLastName"),
		@Mapping(source="entity.chatRooms.roomId", target="roomId"),
	})
	ChatRoomParticipantsDto toDto(ChatRoomParticipants entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ChatRoomParticipantsDto> toDtos(List<ChatRoomParticipants> entities) throws ParseException;

    default ChatRoomParticipantsDto toLiteDto(ChatRoomParticipants entity) {
		if (entity == null) {
			return null;
		}
		ChatRoomParticipantsDto dto = new ChatRoomParticipantsDto();
		dto.setRoomId( entity.getChatRooms().getRoomId() );
		dto.setUserId( entity.getUsers().getUserId() );
		return dto;
    }

	default List<ChatRoomParticipantsDto> toLiteDtos(List<ChatRoomParticipants> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ChatRoomParticipantsDto> dtos = new ArrayList<ChatRoomParticipantsDto>();
		for (ChatRoomParticipants entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="users", target="users"),
		@Mapping(source="chatRooms", target="chatRooms"),
	})
    ChatRoomParticipants toEntity(ChatRoomParticipantsDto dto, Users users, ChatRooms chatRooms) throws ParseException;

    //List<ChatRoomParticipants> toEntities(List<ChatRoomParticipantsDto> dtos) throws ParseException;

}
