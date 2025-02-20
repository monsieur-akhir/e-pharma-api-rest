package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ChatMessageAttachments;
import dev.backend.epharmaApp.dao.entity.ChatMessages;
import dev.backend.epharmaApp.utils.dto.ChatMessageAttachmentsDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T13:29:16+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.21 (Oracle Corporation)"
)
public class ChatMessageAttachmentsTransformerImpl implements ChatMessageAttachmentsTransformer {

    @Override
    public ChatMessageAttachmentsDto toDto(ChatMessageAttachments entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ChatMessageAttachmentsDto chatMessageAttachmentsDto = new ChatMessageAttachmentsDto();

        if ( entity.getCreatedAt() != null ) {
            chatMessageAttachmentsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            chatMessageAttachmentsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            chatMessageAttachmentsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        chatMessageAttachmentsDto.setMessageId( entityChatMessagesMessageId( entity ) );
        chatMessageAttachmentsDto.setAttachmentId( entity.getAttachmentId() );
        chatMessageAttachmentsDto.setFileType( entity.getFileType() );
        chatMessageAttachmentsDto.setFileName( entity.getFileName() );
        chatMessageAttachmentsDto.setFileData( entity.getFileData() );
        chatMessageAttachmentsDto.setRecordStatus( entity.getRecordStatus() );
        chatMessageAttachmentsDto.setCreatedBy( entity.getCreatedBy() );
        chatMessageAttachmentsDto.setUpdatedBy( entity.getUpdatedBy() );
        chatMessageAttachmentsDto.setIsDeleted( entity.getIsDeleted() );
        chatMessageAttachmentsDto.setDeletedBy( entity.getDeletedBy() );

        return chatMessageAttachmentsDto;
    }

    @Override
    public List<ChatMessageAttachmentsDto> toDtos(List<ChatMessageAttachments> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ChatMessageAttachmentsDto> list = new ArrayList<ChatMessageAttachmentsDto>( entities.size() );
        for ( ChatMessageAttachments chatMessageAttachments : entities ) {
            list.add( toDto( chatMessageAttachments ) );
        }

        return list;
    }

    @Override
    public ChatMessageAttachments toEntity(ChatMessageAttachmentsDto dto, ChatMessages chatMessages) throws ParseException {
        if ( dto == null && chatMessages == null ) {
            return null;
        }

        ChatMessageAttachments chatMessageAttachments = new ChatMessageAttachments();

        if ( dto != null ) {
            chatMessageAttachments.setAttachmentId( dto.getAttachmentId() );
            chatMessageAttachments.setFileType( dto.getFileType() );
            chatMessageAttachments.setFileName( dto.getFileName() );
            chatMessageAttachments.setFileData( dto.getFileData() );
            chatMessageAttachments.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                chatMessageAttachments.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            chatMessageAttachments.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                chatMessageAttachments.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            chatMessageAttachments.setUpdatedBy( dto.getUpdatedBy() );
            chatMessageAttachments.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                chatMessageAttachments.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            chatMessageAttachments.setDeletedBy( dto.getDeletedBy() );
        }
        chatMessageAttachments.setChatMessages( chatMessages );

        return chatMessageAttachments;
    }

    private Integer entityChatMessagesMessageId(ChatMessageAttachments chatMessageAttachments) {
        if ( chatMessageAttachments == null ) {
            return null;
        }
        ChatMessages chatMessages = chatMessageAttachments.getChatMessages();
        if ( chatMessages == null ) {
            return null;
        }
        Integer messageId = chatMessages.getMessageId();
        if ( messageId == null ) {
            return null;
        }
        return messageId;
    }
}
