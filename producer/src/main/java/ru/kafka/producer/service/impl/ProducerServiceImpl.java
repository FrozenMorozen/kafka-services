package ru.kafka.producer.service.impl;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
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
        kafkaTemplate.setDefaultTopic(kafkaProperties.getTemplate().getDefaultTopic());

        ProducerEntity entityForSend = producerDataService.getSomethingDataForUUID(id);
        Message<ProducerEntity> message = MessageBuilder
                .withPayload(entityForSend)
                .setHeader("UUID", id)
                .build();
        kafkaTemplate.send(message);
        return "Published successfully!\n";
    }
}
