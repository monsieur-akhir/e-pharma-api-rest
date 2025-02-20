

/*
 * Java transformer for entity table chat_messages 
 * Created on 2025-02-15 ( Time 03:02:40 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import dev.backend.epharmaApp.utils.contract.*;
import dev.backend.epharmaApp.utils.dto.*;
import dev.backend.epharmaApp.dao.entity.*;


/**
 * TRANSFORMER for table "chat_messages"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ChatMessagesTransformer {

	ChatMessagesTransformer INSTANCE = Mappers.getMapper(ChatMessagesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.sentAt", dateFormat="dd/MM/yyyy",target="sentAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.users.userId", target="senderId"),
		@Mapping(source="entity.users.login", target="usersLogin"),
		@Mapping(source="entity.users.firstName", target="usersFirstName"),
		@Mapping(source="entity.users.lastName", target="usersLastName"),
		@Mapping(source="entity.chatRooms.roomId", target="roomId"),
	})
	ChatMessagesDto toDto(ChatMessages entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ChatMessagesDto> toDtos(List<ChatMessages> entities) throws ParseException;

    default ChatMessagesDto toLiteDto(ChatMessages entity) {
		if (entity == null) {
			return null;
		}
		ChatMessagesDto dto = new ChatMessagesDto();
		dto.setMessageId( entity.getMessageId() );
		return dto;
    }

	default List<ChatMessagesDto> toLiteDtos(List<ChatMessages> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ChatMessagesDto> dtos = new ArrayList<ChatMessagesDto>();
		for (ChatMessages entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.messageId", target="messageId"),
		@Mapping(source="dto.message", target="message"),
		@Mapping(source="dto.sentAt", dateFormat="dd/MM/yyyy",target="sentAt"),
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
    ChatMessages toEntity(ChatMessagesDto dto, Users users, ChatRooms chatRooms) throws ParseException;

    //List<ChatMessages> toEntities(List<ChatMessagesDto> dtos) throws ParseException;

}
