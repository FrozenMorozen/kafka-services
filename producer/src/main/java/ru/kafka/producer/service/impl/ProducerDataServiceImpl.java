package ru.kafka.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.SomethingEntityRepository;
import ru.kafka.producer.dto.model.ProducerEntity;
import ru.kafka.producer.service.ProducerDataService;

import java.util.UUID;

@Service
public class ProducerDataServiceImpl implements ProducerDataService {

    private final SomethingEntityRepository somethingEntityRepository;

    @Autowired
    public ProducerDataServiceImpl(SomethingEntityRepository somethingEntityRepository) {
        this.somethingEntityRepository = somethingEntityRepository;
    }

    @Override
    public ProducerEntity getSomethingDataForUUID(UUID uuid) {
        // Имимтация вызова сервиса, который по UUID достает данные
        return somethingEntityRepository.getDataForId(uuid);
    }
}
