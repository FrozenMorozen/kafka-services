package ru.kafka.consumer.dto.converter.impl;

import org.springframework.stereotype.Service;
import ru.kafka.consumer.dao.model.ConsumerDaoEntity;
import ru.kafka.consumer.dto.converter.ConverterDto;
import ru.kafka.consumer.dto.model.ConsumerModel;

@Service
public class ConsumerModelConverter implements ConverterDto<ConsumerModel, ConsumerDaoEntity> {

    @Override
    public ConsumerModel convert(ConsumerDaoEntity source) {
        if (source == null) {
            return null;
        }
        ConsumerModel dtoModel = new ConsumerModel();
        dtoModel.setName(source.getName());
        Long sum = source.getSum();
        Long multiplier = source.getMultiplier();
        dtoModel.setMultipliedSum(
                (sum == null || multiplier == null) ? null : String.valueOf(sum * multiplier)
        );
        return dtoModel;
    }
}
