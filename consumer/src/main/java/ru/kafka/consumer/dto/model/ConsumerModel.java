package ru.kafka.consumer.dto.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ConsumerModel implements DtoModel {
    private String uuid;
    private String name;
    private String multipliedSum;

    @Override
    public String toString() {
        return "{" +
                "uuid=\"" + uuid + "\"" +
                ", name=\"" + name + "\""  +
                ", multipliedSum=\"" + multipliedSum + "\""  +
                '}';
    }
}
