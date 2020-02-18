package ru.kafka.producer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.ProducerEntityRepository;
import ru.kafka.producer.dao.entity.ProducerEntity;
import ru.kafka.producer.dto.converter.ConverterDto;
import ru.kafka.producer.dto.model.ProducerModel;
import ru.kafka.producer.service.ProducerDataService;

import java.util.UUID;

@Service
@Slf4j
public class ProducerDataServiceImpl implements ProducerDataService {

    private final ProducerEntityRepository producerEntityRepository;
    private final ConverterDto<ProducerModel, ProducerEntity> producerDtoConverter;

    public ProducerDataServiceImpl(ProducerEntityRepository producerEntityRepository, ConverterDto<ProducerModel, ProducerEntity> producerDtoConverter) {
        this.producerEntityRepository = producerEntityRepository;
        this.producerDtoConverter = producerDtoConverter;
    }

    @Override
    public ProducerModel getSomethingDataForUUID(UUID uuid) {
        ProducerModel dtoModel = producerDtoConverter.convert(producerEntityRepository.getDataForId(uuid));
        log.info("Для id =\"" + uuid + "\" получены данные: " + dtoModel);
        return dtoModel;
    }
}
