package ru.kafka.producer.dao.mock;

import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.SomethingEntityRepository;
import ru.kafka.producer.dto.model.SomethingEntity;

import java.util.UUID;

/**
 * Заглушка для DAO сервиса
 */
@Service
public class SomethingEntityRepositoryMock implements SomethingEntityRepository {
    @Override
    public SomethingEntity getDataForId(UUID id) {
        return new SomethingEntity("name", 1L, 2L);
    }
}
