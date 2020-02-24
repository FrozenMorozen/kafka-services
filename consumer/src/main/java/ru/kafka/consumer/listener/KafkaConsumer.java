package ru.kafka.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.kafka.consumer.dao.model.ConsumerDaoEntity;
import ru.kafka.consumer.dto.model.ConsumerModel;
import ru.kafka.consumer.service.ConsumerService;

@Service
@Slf4j
public class KafkaConsumer {

    @Autowired
    private ConsumerService consumerService;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(@Header("UUID") String uuid, @Payload ConsumerDaoEntity consumerDaoEntity) {
        ConsumerModel consumerModel = consumerService.somethingAction(uuid, consumerDaoEntity);
        if (consumerModel != null) {
            log.debug(consumerModel.toString());
        }
    }
}
