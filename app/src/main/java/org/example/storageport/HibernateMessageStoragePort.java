package org.example.storageport;

import lombok.RequiredArgsConstructor;
import org.example.entity.Message;
import org.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HibernateMessageStoragePort {

    @Autowired
    private final MessageRepository messageRepository;

    @Transactional
    public Message create(Message message) {
        return messageRepository.saveAndFlush(message);
    }

    @Transactional
    public Message get(UUID id) {
        return messageRepository.getReferenceById(id);
    }

    @Transactional
    public List<Message> getAll(){
        return messageRepository.findAll();
    }

    @Transactional
    public Integer getStatisticProcessedMessage() {
        return messageRepository.getStatisticProcessedMessage();
    }
}
