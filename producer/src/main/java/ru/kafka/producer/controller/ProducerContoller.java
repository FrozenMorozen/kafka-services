package ru.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kafka.producer.dto.model.SomethingData;

@RestController
@RequestMapping("test")
public class ProducerContoller {

    private static final String TOPIC = "test_topic";

    @Autowired
    private KafkaTemplate<String, SomethingData> kafkaTemplate;

    @GetMapping("/{id}")
    public String post(@PathVariable("id") final String id) {
        kafkaTemplate.send(TOPIC, new SomethingData(Long.valueOf(id)));
        return "Published successfully!";
    }
}
