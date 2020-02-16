package ru.kafka.producer.dao;

import ru.kafka.producer.dto.model.SomethingEntity;

import java.util.UUID;

/**
 * Это может быть сервис обеспечивающий доступ к БД
 * или получающий данные из другого микросервиса(из kafka)
 */
public interface SomethingEntityRepository {

    /**
     * Получить данные для id
     */
    SomethingEntity getDataForId(UUID id);
}
