package ru.kafka.producer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.ProducerEntityRepository;
import ru.kafka.producer.dto.model.ProducerEntity;
import ru.kafka.producer.service.ProducerDataService;

import java.util.UUID;

@Service
@Slf4j
public class ProducerDataServiceImpl implements ProducerDataService {

    private final ProducerEntityRepository producerEntityRepository;

    public ProducerDataServiceImpl(ProducerEntityRepository producerEntityRepository) {
        this.producerEntityRepository = producerEntityRepository;
    }

    @Override
    public ProducerEntity getSomethingDataForUUID(UUID uuid) {
        // Имимтация вызова сервиса, который по UUID получает данные
        ProducerEntity entityForSend = producerEntityRepository.getDataForId(uuid);
        log.debug("Для id =\"" + uuid + "\" получена сущность: " + entityForSend);
        return entityForSend;
    }
}
