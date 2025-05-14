package org.example.controller;

import org.example.dto.MessageDto;
import org.example.dto.mapper.MessageMapper;
import org.example.dto.response.ResponseMessage;
import org.example.exception.MessageException;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService service;
    private final MessageMapper mapper;

    @Autowired
    public MessageController(MessageService service, MessageMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public ResponseMessage create(MessageDto messageDto) throws MessageException {
        return mapper.dtoToResponse(service.create(messageDto));
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
    public ResponseMessage get(UUID id) throws MessageException {
        return mapper.dtoToResponse(service.get(id));
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public List<ResponseMessage> getAll() throws MessageException {
        return service.getAll().stream().map(mapper::dtoToResponse).toList();
    }
    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public Integer getStatisticProcessedMessage(){
        return service.getStatisticProcessedMessage();
    }
}
