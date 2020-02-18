package ru.kafka.producer.dao;

import ru.kafka.producer.dao.entity.ProducerEntity;

import java.util.UUID;

/**
 * Это может быть сервис обеспечивающий доступ к БД или получающий данные из другого микросервиса
 */
public interface ProducerEntityRepository {

    /**
     * Получить данные для id
     */
    ProducerEntity getDataForId(UUID id);
}
