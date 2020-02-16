package ru.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kafka.producer.dto.model.SomethingEntity;
import ru.kafka.producer.service.SomethingDataService;

import java.util.UUID;

@RestController
@RequestMapping("test")
public class ProducerContoller {

    private static final String TOPIC = "test_topic";

    @Autowired
    private KafkaTemplate<String, SomethingEntity> kafkaTemplate;

    @Autowired
    private SomethingDataService somethingDataService;

    @GetMapping("/{id}")
    public String post(@PathVariable("id") final String id) {
        kafkaTemplate.send(TOPIC, somethingDataService.getSomethingDataForUUID(UUID.fromString(id)));
        return "Published successfully!";
    }
}
