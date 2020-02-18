package ru.kafka.producer.service;

import java.util.UUID;

/**
 * Сервис базовой логики сервера
 */
public interface ProducerService {

    /**
     * Отправить сообщение с id
     *
     * @return информация о результате отправки
     */
    String send(UUID id);
}
