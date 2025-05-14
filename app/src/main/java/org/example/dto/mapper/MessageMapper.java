package org.example.dto.mapper;

import org.example.dto.MessageDto;
import org.example.dto.response.ResponseMessage;
import org.example.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    @Mapping(target = "createdAt", source = "timestamp")
    Message toEntity(MessageDto dto);

    @Mapping(target = "timestamp", source = "createdAt")
    MessageDto toDto(Message entity);

    @Mapping(target = "messageId", source = "id")
    @Mapping(target = "processedAt", source = "timestamp")
    ResponseMessage dtoToResponse (MessageDto dto);
}
