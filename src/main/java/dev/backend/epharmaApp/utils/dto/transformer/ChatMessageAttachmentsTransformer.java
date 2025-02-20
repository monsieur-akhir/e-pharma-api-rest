

/*
 * Java transformer for entity table chat_message_attachments 
 * Created on 2025-02-15 ( Time 03:02:39 )
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
 * TRANSFORMER for table "chat_message_attachments"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ChatMessageAttachmentsTransformer {

	ChatMessageAttachmentsTransformer INSTANCE = Mappers.getMapper(ChatMessageAttachmentsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.chatMessages.messageId", target="messageId"),
	})
	ChatMessageAttachmentsDto toDto(ChatMessageAttachments entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ChatMessageAttachmentsDto> toDtos(List<ChatMessageAttachments> entities) throws ParseException;

    default ChatMessageAttachmentsDto toLiteDto(ChatMessageAttachments entity) {
		if (entity == null) {
			return null;
		}
		ChatMessageAttachmentsDto dto = new ChatMessageAttachmentsDto();
		dto.setAttachmentId( entity.getAttachmentId() );
		return dto;
    }

	default List<ChatMessageAttachmentsDto> toLiteDtos(List<ChatMessageAttachments> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ChatMessageAttachmentsDto> dtos = new ArrayList<ChatMessageAttachmentsDto>();
		for (ChatMessageAttachments entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.attachmentId", target="attachmentId"),
		@Mapping(source="dto.fileType", target="fileType"),
		@Mapping(source="dto.fileName", target="fileName"),
		@Mapping(source="dto.fileData", target="fileData"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="chatMessages", target="chatMessages"),
	})
    ChatMessageAttachments toEntity(ChatMessageAttachmentsDto dto, ChatMessages chatMessages) throws ParseException;

    //List<ChatMessageAttachments> toEntities(List<ChatMessageAttachmentsDto> dtos) throws ParseException;

}
