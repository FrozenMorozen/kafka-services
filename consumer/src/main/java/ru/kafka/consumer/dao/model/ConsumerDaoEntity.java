package ru.kafka.consumer.dao.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kafka.consumer.dto.serialization.ConsumerDaoEntityDeserializer;

@Getter
@Setter
@NoArgsConstructor
@JsonDeserialize(using = ConsumerDaoEntityDeserializer.class)
public class ConsumerDaoEntity {
    private String name;
    private Long sum;
    private Long multiplier;
}
