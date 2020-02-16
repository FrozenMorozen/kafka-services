package ru.kafka.producer.service.impl;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.kafka.producer.dto.model.ProducerEntity;
import ru.kafka.producer.service.ProducerDataService;
import ru.kafka.producer.service.ProducerService;

import java.util.UUID;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String, ProducerEntity> kafkaTemplate;
    private final ProducerDataService producerDataService;
    private final KafkaProperties kafkaProperties;

    public ProducerServiceImpl(KafkaTemplate<String, ProducerEntity> kafkaTemplate, ProducerDataService producerDataService, KafkaProperties kafkaProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.producerDataService = producerDataService;
        this.kafkaProperties = kafkaProperties;
    }

    @Override
    public String send(UUID id) {
        kafkaTemplate.send(kafkaProperties.getTemplate().getDefaultTopic(), producerDataService.getSomethingDataForUUID(id));
        return "Published successfully!";
    }
}
