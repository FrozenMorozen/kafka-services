package ru.kafka.producer.service;

import java.util.UUID;

/**
 * Сервис базовой логики сервера
 */
public interface ProducerService {

    /**
     * Отправить сообщение с id
     */
    String send(UUID id);
}
