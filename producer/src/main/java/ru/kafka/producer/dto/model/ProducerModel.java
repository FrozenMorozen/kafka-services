package ru.kafka.producer.dto.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProducerModel implements DtoModel {
    private String name;
    private Long sum;
    private Long multiplier;
}
