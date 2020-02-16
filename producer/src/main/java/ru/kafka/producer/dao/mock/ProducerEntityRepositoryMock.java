package ru.kafka.producer.dao.mock;

import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.ProducerEntityRepository;
import ru.kafka.producer.dto.model.ProducerEntity;

import java.util.UUID;

/**
 * Заглушка для DAO сервиса
 */
@Service
public class ProducerEntityRepositoryMock implements ProducerEntityRepository {
    @Override
    public ProducerEntity getDataForId(UUID id) {
        return new ProducerEntity("name", 1L, 2L);
    }
}
