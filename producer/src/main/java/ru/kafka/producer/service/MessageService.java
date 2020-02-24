package ru.kafka.producer.service;

import org.springframework.messaging.Message;
import ru.kafka.producer.dto.model.ProducerModel;

import java.util.UUID;

/**
 * Обработка сообщений для producer
 */
public interface MessageService {

    /**
     * Создать сообщение, содержащие данные  полученные для uuid
     *
     * @param uuid uuid сообщения
     * @return сообщение с uuid в заголовке
     */
    Message<ProducerModel> createMessageForUuid(UUID uuid);
}
