package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ChatRoomParticipants;
import dev.backend.epharmaApp.dao.entity.ChatRooms;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.ChatRoomParticipantsDto;
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
public class ChatRoomParticipantsTransformerImpl implements ChatRoomParticipantsTransformer {

    @Override
    public ChatRoomParticipantsDto toDto(ChatRoomParticipants entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ChatRoomParticipantsDto chatRoomParticipantsDto = new ChatRoomParticipantsDto();

        if ( entity.getCreatedAt() != null ) {
            chatRoomParticipantsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            chatRoomParticipantsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            chatRoomParticipantsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        chatRoomParticipantsDto.setUserId( entityUsersUserId( entity ) );
        chatRoomParticipantsDto.setUsersLogin( entityUsersLogin( entity ) );
        chatRoomParticipantsDto.setUsersFirstName( entityUsersFirstName( entity ) );
        chatRoomParticipantsDto.setUsersLastName( entityUsersLastName( entity ) );
        chatRoomParticipantsDto.setRoomId( entityChatRoomsRoomId( entity ) );
        chatRoomParticipantsDto.setRecordStatus( entity.getRecordStatus() );
        chatRoomParticipantsDto.setCreatedBy( entity.getCreatedBy() );
        chatRoomParticipantsDto.setUpdatedBy( entity.getUpdatedBy() );
        chatRoomParticipantsDto.setIsDeleted( entity.getIsDeleted() );
        chatRoomParticipantsDto.setDeletedBy( entity.getDeletedBy() );

        return chatRoomParticipantsDto;
    }

    @Override
    public List<ChatRoomParticipantsDto> toDtos(List<ChatRoomParticipants> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ChatRoomParticipantsDto> list = new ArrayList<ChatRoomParticipantsDto>( entities.size() );
        for ( ChatRoomParticipants chatRoomParticipants : entities ) {
            list.add( toDto( chatRoomParticipants ) );
        }

        return list;
    }

    @Override
    public ChatRoomParticipants toEntity(ChatRoomParticipantsDto dto, Users users, ChatRooms chatRooms) throws ParseException {
        if ( dto == null && users == null && chatRooms == null ) {
            return null;
        }

        ChatRoomParticipants chatRoomParticipants = new ChatRoomParticipants();

        if ( dto != null ) {
            chatRoomParticipants.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                chatRoomParticipants.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            chatRoomParticipants.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                chatRoomParticipants.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            chatRoomParticipants.setUpdatedBy( dto.getUpdatedBy() );
            chatRoomParticipants.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                chatRoomParticipants.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            chatRoomParticipants.setDeletedBy( dto.getDeletedBy() );
        }
        chatRoomParticipants.setUsers( users );
        chatRoomParticipants.setChatRooms( chatRooms );

        return chatRoomParticipants;
    }

    private Integer entityUsersUserId(ChatRoomParticipants chatRoomParticipants) {
        if ( chatRoomParticipants == null ) {
            return null;
        }
        Users users = chatRoomParticipants.getUsers();
        if ( users == null ) {
            return null;
        }
        Integer userId = users.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String entityUsersLogin(ChatRoomParticipants chatRoomParticipants) {
        if ( chatRoomParticipants == null ) {
            return null;
        }
        Users users = chatRoomParticipants.getUsers();
        if ( users == null ) {
            return null;
        }
        String login = users.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String entityUsersFirstName(ChatRoomParticipants chatRoomParticipants) {
        if ( chatRoomParticipants == null ) {
            return null;
        }
        Users users = chatRoomParticipants.getUsers();
        if ( users == null ) {
            return null;
        }
        String firstName = users.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityUsersLastName(ChatRoomParticipants chatRoomParticipants) {
        if ( chatRoomParticipants == null ) {
            return null;
        }
        Users users = chatRoomParticipants.getUsers();
        if ( users == null ) {
            return null;
        }
        String lastName = users.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private Integer entityChatRoomsRoomId(ChatRoomParticipants chatRoomParticipants) {
        if ( chatRoomParticipants == null ) {
            return null;
        }
        ChatRooms chatRooms = chatRoomParticipants.getChatRooms();
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
