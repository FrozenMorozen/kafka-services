package ru.kafka.consumer.listener;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.kafka.consumer.dto.model.ConsumerEntity;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

//    @KafkaListener(topics = TOPIC, groupId = "group_json", containerFactory = "consumerEntityKafkaListenerFactory")
//    public void consumeJson(ConsumerEntity consumerEntity) {
//        System.out.println("Consumed JSON Message: " + consumerEntity);
//    }
}
