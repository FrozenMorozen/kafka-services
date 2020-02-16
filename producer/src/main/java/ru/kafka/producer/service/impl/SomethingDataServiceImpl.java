package ru.kafka.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.SomethingEntityRepository;
import ru.kafka.producer.dto.model.SomethingEntity;
import ru.kafka.producer.service.SomethingDataService;

import java.util.UUID;

@Service
public class SomethingDataServiceImpl implements SomethingDataService {

    private final SomethingEntityRepository somethingEntityRepository;

    @Autowired
    public SomethingDataServiceImpl(SomethingEntityRepository somethingEntityRepository) {
        this.somethingEntityRepository = somethingEntityRepository;
    }

    @Override
    public SomethingEntity getSomethingDataForUUID(UUID uuid) {
        // Имимтация вызова сервиса, который по UUID достает данные
        return somethingEntityRepository.getDataForId(uuid);
    }
}
