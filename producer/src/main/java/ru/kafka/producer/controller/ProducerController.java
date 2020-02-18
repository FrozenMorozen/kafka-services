package ru.kafka.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kafka.producer.service.ProducerService;

import java.util.UUID;

@RestController
@RequestMapping("test")
@Slf4j
public class ProducerController {

    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/{id}")
    public String post(@PathVariable("id") final String id) {
        log.info("UUID from http : " + id);
        return producerService.send(UUID.fromString(id));
    }
}
