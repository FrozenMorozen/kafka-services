package ru.kafka.producer.service;

import ru.kafka.producer.dto.model.SomethingEntity;

import java.util.UUID;

/**
 * Сервис для какой-нибудь логики, связанной с моделью {@link SomethingEntity}
 */
public interface SomethingDataService {

    /**
     * Предположил, что для полученного через entry point UUID
     * требуется достать сущность {@link SomethingEntity}
     * @param uuid id для получения сущности
     */
    SomethingEntity getSomethingDataForUUID(UUID uuid);
}
