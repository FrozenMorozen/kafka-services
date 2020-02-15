package ru.kafka.producer.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SomethingData {

    private Long id; // временно
    private String name;
    private Long sum;
    private Long multiplier;

    public SomethingData(Long id) {
        this.id = id;
        this.name = "name";
        this.sum = 1L;
        this.multiplier = 2L;
    }

}
