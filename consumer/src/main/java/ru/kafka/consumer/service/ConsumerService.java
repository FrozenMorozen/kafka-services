package ru.kafka.consumer.service;

import ru.kafka.consumer.dao.model.ConsumerDaoEntity;
import ru.kafka.consumer.dto.model.ConsumerModel;

/**
 *  Сервис для какой-нибудь централизованной логкик consumer
 */
public interface ConsumerService {

    /**
     * Выполнить какую-то обработку dao сущности
     * @param uuid              uuid для dto модели
     * @param consumerEntity    dao сущность
     * @return dto модель для дальнейших действий внутри приложения
     */
    ConsumerModel somethingAction(String uuid, ConsumerDaoEntity consumerEntity);
}
