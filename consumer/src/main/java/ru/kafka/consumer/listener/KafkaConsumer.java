package ru.kafka.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.kafka.consumer.dto.model.ConsumerEntity;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(@Header("UUID") String UUID, @Payload ConsumerEntity consumerEntity) {
        consumerEntity.setUuid(UUID);
        log.debug(consumerEntity.toString());
    }
}
