package ru.kafka.producer.service;

import ru.kafka.producer.dto.model.ProducerModel;

import java.util.UUID;

/**
 * Сервис для обработки модели {@link ProducerModel}
 */
public interface ProducerDataService {

    /**
     * Для полученного через entry point UUID требуется получить модель {@link ProducerModel}
     *
     * @param uuid id для получения сущности
     */
    ProducerModel getSomethingDataForUUID(UUID uuid);
}
