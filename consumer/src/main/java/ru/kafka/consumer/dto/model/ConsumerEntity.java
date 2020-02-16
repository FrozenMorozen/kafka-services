package ru.kafka.consumer.dto.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConsumerEntity {
    private String uuid;
    private String name;
    private String multipliedSum;
}
