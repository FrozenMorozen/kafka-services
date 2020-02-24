package ru.kafka.producer.service;

import ru.kafka.producer.dto.model.ProducerModel;

import java.util.UUID;

/**
 * Сервис для агрегирования данных в dto модели приложения
 */
public interface ProducerDataService {

    /**
     * Для полученного по http UUID получить модель {@link ProducerModel}
     */
    ProducerModel getSomethingDataForUUID(UUID uuid);
}
