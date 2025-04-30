package org.example.kafka.consumer;

import org.example.dto.MessageDto;
import org.example.dto.mapper.MessageMapper;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final MessageService service;
    private final MessageMapper mapper;
    private final KafkaTemplate<Object, Object> template;

    @Autowired
    public KafkaConsumer(MessageService service, MessageMapper mapper, KafkaTemplate<Object, Object> template) {
        this.service = service;
        this.mapper = mapper;
        this.template = template;
    }

    @KafkaListener(id = "input", topics = "input-messages")
    public void listen(MessageDto message) {
        template.send("output-messages", message);
    }
}
