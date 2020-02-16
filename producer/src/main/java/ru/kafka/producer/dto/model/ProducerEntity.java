package ru.kafka.producer.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProducerEntity {
    private String name;
    private Long sum;
    private Long multiplier;
}
