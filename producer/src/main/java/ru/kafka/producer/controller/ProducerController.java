package ru.kafka.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kafka.producer.dto.model.ProducerModel;
import ru.kafka.producer.service.MessageService;

import java.util.UUID;

@RestController
@RequestMapping("test")
@Slf4j
public class ProducerController {

    private static final String SUCCESSFUL_SENDING_INFO = "Published successfully!\n";

    private MessageService messageService;
    private KafkaTemplate<String, ProducerModel> kafkaTemplate;

    @Autowired
    public ProducerController(MessageService messageService, KafkaTemplate<String, ProducerModel> kafkaTemplate) {
        this.messageService = messageService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/{id}")
    public String post(@PathVariable("id") final String id) {
        log.info("UUID from http : " + id);
        kafkaTemplate.send(messageService.createMessageForUuid(UUID.fromString(id)));
        return SUCCESSFUL_SENDING_INFO;
    }
}
