package ru.kafka.producer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.kafka.producer.dto.model.ProducerModel;
import ru.kafka.producer.service.ProducerDataService;
import ru.kafka.producer.service.ProducerService;

import java.util.UUID;

@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService {

    private static final String SUCCESSFUL_SENDING_INFO = "Published successfully!\n";

    private final KafkaTemplate<String, ProducerModel> kafkaTemplate;
    private final ProducerDataService producerDataService;

    public ProducerServiceImpl(KafkaTemplate<String, ProducerModel> kafkaTemplate, ProducerDataService producerDataService) {
        this.kafkaTemplate = kafkaTemplate;
        this.producerDataService = producerDataService;
    }

    @Override
    public String send(UUID id) {
        ProducerModel entityForSend = producerDataService.getSomethingDataForUUID(id);
        Message<ProducerModel> message = MessageBuilder
                .withPayload(entityForSend)
                .setHeader("UUID", id)
                .build();
        kafkaTemplate.send(message);
        log.info("Сообщение {} успешно отправлено", message);
        return SUCCESSFUL_SENDING_INFO;
    }
}
