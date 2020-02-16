package ru.kafka.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.kafka.consumer.dto.model.ConsumerEntity;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(ConsumerEntity consumerEntity) {
        log.debug(consumerEntity.toString());
    }
}
