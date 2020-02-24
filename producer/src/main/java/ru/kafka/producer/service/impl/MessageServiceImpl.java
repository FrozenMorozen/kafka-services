package ru.kafka.producer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.kafka.producer.dto.model.ProducerModel;
import ru.kafka.producer.service.MessageService;
import ru.kafka.producer.service.ProducerDataService;

import java.util.UUID;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

  private ProducerDataService producerDataService;

  @Autowired
  public MessageServiceImpl(ProducerDataService producerDataService) {
    this.producerDataService = producerDataService;
  }

  @Override
  public Message<ProducerModel> createMessageForUuid(UUID uuid) {
    ProducerModel entityForSend = producerDataService.getSomethingDataForUUID(uuid);
    return entityForSend == null ? null :
            MessageBuilder.withPayload(entityForSend).setHeader("UUID", uuid).build();
  }
}
