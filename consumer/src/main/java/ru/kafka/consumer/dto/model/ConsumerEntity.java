package ru.kafka.consumer.dto.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import ru.kafka.consumer.dto.serialization.ConsumerEntityDeserializer;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonDeserialize(using = ConsumerEntityDeserializer.class)
public class ConsumerEntity {
    private String uuid;
    private String name;
    private String multipliedSum;
}
