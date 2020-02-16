package ru.kafka.producer.dao;

import ru.kafka.producer.dto.model.ProducerEntity;

import java.util.UUID;

/**
 * Это может быть сервис обеспечивающий доступ к БД
 * или получающий данные из другого микросервиса(из kafka)
 */
public interface ProducerEntityRepository {

    /**
     * Получить данные для id
     */
    ProducerEntity getDataForId(UUID id);
}
