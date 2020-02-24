package ru.kafka.consumer.dto.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ConsumerModel implements DtoModel {
    private String uuid;
    private String name;
    private String multipliedSum;
}
