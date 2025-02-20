package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ChatMessages;
import dev.backend.epharmaApp.dao.entity.ChatRooms;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.ChatMessagesDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T13:29:15+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.21 (Oracle Corporation)"
)
public class ChatMessagesTransformerImpl implements ChatMessagesTransformer {

    @Override
    public ChatMessagesDto toDto(ChatMessages entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ChatMessagesDto chatMessagesDto = new ChatMessagesDto();

        if ( entity.getSentAt() != null ) {
            chatMessagesDto.setSentAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getSentAt() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            chatMessagesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            chatMessagesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            chatMessagesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        chatMessagesDto.setSenderId( entityUsersUserId( entity ) );
        chatMessagesDto.setUsersLogin( entityUsersLogin( entity ) );
        chatMessagesDto.setUsersFirstName( entityUsersFirstName( entity ) );
        chatMessagesDto.setUsersLastName( entityUsersLastName( entity ) );
        chatMessagesDto.setRoomId( entityChatRoomsRoomId( entity ) );
        chatMessagesDto.setMessageId( entity.getMessageId() );
        chatMessagesDto.setMessage( entity.getMessage() );
        chatMessagesDto.setRecordStatus( entity.getRecordStatus() );
        chatMessagesDto.setCreatedBy( entity.getCreatedBy() );
        chatMessagesDto.setUpdatedBy( entity.getUpdatedBy() );
        chatMessagesDto.setIsDeleted( entity.getIsDeleted() );
        chatMessagesDto.setDeletedBy( entity.getDeletedBy() );

        return chatMessagesDto;
    }

    @Override
    public List<ChatMessagesDto> toDtos(List<ChatMessages> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ChatMessagesDto> list = new ArrayList<ChatMessagesDto>( entities.size() );
        for ( ChatMessages chatMessages : entities ) {
            list.add( toDto( chatMessages ) );
        }

        return list;
    }

    @Override
    public ChatMessages toEntity(ChatMessagesDto dto, Users users, ChatRooms chatRooms) throws ParseException {
        if ( dto == null && users == null && chatRooms == null ) {
            return null;
        }

        ChatMessages chatMessages = new ChatMessages();

        if ( dto != null ) {
            chatMessages.setMessageId( dto.getMessageId() );
            chatMessages.setMessage( dto.getMessage() );
            if ( dto.getSentAt() != null ) {
                chatMessages.setSentAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getSentAt() ) );
            }
            chatMessages.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                chatMessages.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            chatMessages.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                chatMessages.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            chatMessages.setUpdatedBy( dto.getUpdatedBy() );
            chatMessages.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                chatMessages.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            chatMessages.setDeletedBy( dto.getDeletedBy() );
        }
        chatMessages.setUsers( users );
        chatMessages.setChatRooms( chatRooms );

        return chatMessages;
    }

    private Integer entityUsersUserId(ChatMessages chatMessages) {
        if ( chatMessages == null ) {
            return null;
        }
        Users users = chatMessages.getUsers();
        if ( users == null ) {
            return null;
        }
        Integer userId = users.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String entityUsersLogin(ChatMessages chatMessages) {
        if ( chatMessages == null ) {
            return null;
        }
        Users users = chatMessages.getUsers();
        if ( users == null ) {
            return null;
        }
        String login = users.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String entityUsersFirstName(ChatMessages chatMessages) {
        if ( chatMessages == null ) {
            return null;
        }
        Users users = chatMessages.getUsers();
        if ( users == null ) {
            return null;
        }
        String firstName = users.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityUsersLastName(ChatMessages chatMessages) {
        if ( chatMessages == null ) {
            return null;
        }
        Users users = chatMessages.getUsers();
        if ( users == null ) {
            return null;
        }
        String lastName = users.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private Integer entityChatRoomsRoomId(ChatMessages chatMessages) {
        if ( chatMessages == null ) {
            return null;
        }
        ChatRooms chatRooms = chatMessages.getChatRooms();
        if ( chatRooms == null ) {
            return null;
        }
        Integer roomId = chatRooms.getRoomId();
        if ( roomId == null ) {
            return null;
        }
        return roomId;
    }
}
