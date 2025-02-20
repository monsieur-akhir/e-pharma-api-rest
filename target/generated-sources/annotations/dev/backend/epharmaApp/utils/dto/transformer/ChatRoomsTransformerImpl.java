package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ChatRooms;
import dev.backend.epharmaApp.utils.dto.ChatRoomsDto;
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
public class ChatRoomsTransformerImpl implements ChatRoomsTransformer {

    @Override
    public ChatRoomsDto toDto(ChatRooms entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ChatRoomsDto chatRoomsDto = new ChatRoomsDto();

        if ( entity.getCreatedAt() != null ) {
            chatRoomsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            chatRoomsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            chatRoomsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        chatRoomsDto.setRoomId( entity.getRoomId() );
        chatRoomsDto.setRoomName( entity.getRoomName() );
        chatRoomsDto.setRecordStatus( entity.getRecordStatus() );
        chatRoomsDto.setCreatedBy( entity.getCreatedBy() );
        chatRoomsDto.setUpdatedBy( entity.getUpdatedBy() );
        chatRoomsDto.setIsDeleted( entity.getIsDeleted() );
        chatRoomsDto.setDeletedBy( entity.getDeletedBy() );

        return chatRoomsDto;
    }

    @Override
    public List<ChatRoomsDto> toDtos(List<ChatRooms> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ChatRoomsDto> list = new ArrayList<ChatRoomsDto>( entities.size() );
        for ( ChatRooms chatRooms : entities ) {
            list.add( toDto( chatRooms ) );
        }

        return list;
    }

    @Override
    public ChatRooms toEntity(ChatRoomsDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        ChatRooms chatRooms = new ChatRooms();

        chatRooms.setRoomId( dto.getRoomId() );
        chatRooms.setRoomName( dto.getRoomName() );
        chatRooms.setRecordStatus( dto.getRecordStatus() );
        if ( dto.getCreatedAt() != null ) {
            chatRooms.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        chatRooms.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getUpdatedAt() != null ) {
            chatRooms.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        chatRooms.setUpdatedBy( dto.getUpdatedBy() );
        chatRooms.setIsDeleted( dto.getIsDeleted() );
        if ( dto.getDeletedAt() != null ) {
            chatRooms.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
        }
        chatRooms.setDeletedBy( dto.getDeletedBy() );

        return chatRooms;
    }
}
