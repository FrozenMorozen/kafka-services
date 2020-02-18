package ru.kafka.producer.dto.converter;

import org.springframework.stereotype.Service;
import ru.kafka.producer.dao.entity.ProducerEntity;
import ru.kafka.producer.dto.model.ProducerModel;

@Service
public class ProducerModelConverter implements ConverterDto<ProducerModel, ProducerEntity> {

    @Override
    public ProducerModel convert(ProducerEntity source) {
        if (source == null) {
            return null;
        }
        ProducerModel producerModel = new ProducerModel();
        producerModel.setName(source.getName());
        producerModel.setSum(source.getSum());
        producerModel.setMultiplier(source.getMultiplier());
        return producerModel;
    }

    @Override
    public ProducerEntity convert(ProducerModel source) {
        return null;
    }
}
