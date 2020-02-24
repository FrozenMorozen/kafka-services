package ru.kafka.consumer.dto.converter;


import ru.kafka.consumer.dto.model.DtoModel;

/**
 * Ковертер для DTO моделей
 */
public interface ConverterDto<T extends DtoModel, C> {

    /**
     * Конвретация в DTO модель
     */
    T convert(C source);
}
