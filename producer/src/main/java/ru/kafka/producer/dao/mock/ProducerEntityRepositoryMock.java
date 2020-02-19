package ru.kafka.producer.dao.mock;

import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.ProducerEntityRepository;
import ru.kafka.producer.dao.entity.ProducerEntity;

import java.util.UUID;

/**
 * Заглушка для DAO сервиса
 */
@Service
public class ProducerEntityRepositoryMock implements ProducerEntityRepository {
    @Override
    public ProducerEntity getDataForId(UUID id) {
        if (id == null) {
            return null;
        }
        // Какой-нибудь запрос или метод для получения dao сущности
        return new ProducerEntity("name", 1L, 2L);
    }
}
