package ru.kafka.producer.dao.entity;

import lombok.Getter;

@Getter
public class ProducerEntity {
    private String name;
    private Long sum;
    private Long multiplier;

    private int firstSomeValue;
    private String secondSomeValue;

    public ProducerEntity(String name, Long sum, Long multiplier) {
        this.name = name;
        this.sum = sum;
        this.multiplier = multiplier;
    }
}
