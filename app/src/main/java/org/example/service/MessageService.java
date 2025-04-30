package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.MessageDto;
import org.example.dto.mapper.MessageMapper;
import org.example.entity.Status;
import org.example.exception.MessageException;
import org.example.storageport.HibernateMessageStoragePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    @Autowired
    private final HibernateMessageStoragePort storagePort;
    private final MessageMapper mapper;

    public MessageDto create(MessageDto messageDto) throws MessageException {

        if (!messageDto.getId().equals(null) || !messageDto.equals(null)) {
            messageDto.setStatus(Status.PROCESSED);
            return mapper.toDto(storagePort.create(mapper.toEntity(messageDto)));
        } else {
            messageDto.setStatus(Status.FAILED);
            log.info("Message id is required field");
            throw new MessageException("Message id is required field");
        }
    }

    public MessageDto get(UUID id) throws MessageException {
        if (id != null) {
            return mapper.toDto(storagePort.get(id));
        } else {
            log.info("Entity not found: {id}");
            throw new MessageException("Message id is required field");
        }
    }

    public List<MessageDto> getAll() throws MessageException {
        return storagePort.getAll().stream().map(mapper::toDto).toList();
    }

    public Integer getStatisticProcessedMessage(){
        return storagePort.getStatisticProcessedMessage();
    }
}
