package ru.kafka.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kafka.consumer.dao.model.ConsumerDaoEntity;
import ru.kafka.consumer.dto.converter.ConverterDto;
import ru.kafka.consumer.dto.model.ConsumerModel;
import ru.kafka.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private ConverterDto<ConsumerModel, ConsumerDaoEntity> consumerDtoConverter;

    @Autowired
    public ConsumerServiceImpl(ConverterDto<ConsumerModel, ConsumerDaoEntity> consumerDtoConverter) {
        this.consumerDtoConverter = consumerDtoConverter;
    }

    @Override
    public ConsumerModel somethingAction(String uuid, ConsumerDaoEntity consumerEntity) {
        ConsumerModel dtoModel = consumerDtoConverter.convert(consumerEntity);
        if (dtoModel != null) {
            dtoModel.setUuid(uuid);
        }
        return dtoModel;
    }
}
