package ru.kafka.producer.service;

import ru.kafka.producer.dto.model.ProducerEntity;

import java.util.UUID;

/**
 * Сервис для обработки модели {@link ProducerEntity}
 */
public interface ProducerDataService {

    /**
     * Предположил, что для полученного через entry point UUID
     * требуется получить сущность {@link ProducerEntity}
     * @param uuid id для получения сущности
     */
    ProducerEntity getSomethingDataForUUID(UUID uuid);
}
