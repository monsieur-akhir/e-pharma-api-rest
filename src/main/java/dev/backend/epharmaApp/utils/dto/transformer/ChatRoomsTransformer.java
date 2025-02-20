

/*
 * Java transformer for entity table chat_rooms 
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
 * TRANSFORMER for table "chat_rooms"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ChatRoomsTransformer {

	ChatRoomsTransformer INSTANCE = Mappers.getMapper(ChatRoomsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
	})
	ChatRoomsDto toDto(ChatRooms entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ChatRoomsDto> toDtos(List<ChatRooms> entities) throws ParseException;

    default ChatRoomsDto toLiteDto(ChatRooms entity) {
		if (entity == null) {
			return null;
		}
		ChatRoomsDto dto = new ChatRoomsDto();
		dto.setRoomId( entity.getRoomId() );
		return dto;
    }

	default List<ChatRoomsDto> toLiteDtos(List<ChatRooms> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ChatRoomsDto> dtos = new ArrayList<ChatRoomsDto>();
		for (ChatRooms entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.roomId", target="roomId"),
		@Mapping(source="dto.roomName", target="roomName"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
	})
    ChatRooms toEntity(ChatRoomsDto dto) throws ParseException;

    //List<ChatRooms> toEntities(List<ChatRoomsDto> dtos) throws ParseException;

}
