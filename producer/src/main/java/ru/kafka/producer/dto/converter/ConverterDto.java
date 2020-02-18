package ru.kafka.producer.dto.converter;

import ru.kafka.producer.dto.model.DtoModel;

/**
 * Ковертер для DTO моделей
 */
public interface ConverterDto<T extends DtoModel, C> {

    /**
     * Конвретация в DTO модель
     */
    T convert(C source);

    /**
     * Ковертация в DAO сущность. Может потребоваться при записи в БД
     */
    C convert(T source);
}
