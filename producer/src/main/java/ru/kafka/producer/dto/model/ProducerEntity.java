package ru.kafka.producer.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProducerEntity {
    private String name;
    private Long sum;
    private Long multiplier;
}
