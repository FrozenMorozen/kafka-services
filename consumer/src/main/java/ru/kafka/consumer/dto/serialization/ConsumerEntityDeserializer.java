package ru.kafka.consumer.dto.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import ru.kafka.consumer.dto.model.ConsumerEntity;

import java.io.IOException;

public class ConsumerEntityDeserializer extends StdDeserializer<ConsumerEntity> {

    public ConsumerEntityDeserializer() {
        this(null);
    }

    public ConsumerEntityDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ConsumerEntity deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        ConsumerEntity consumerEntity = new ConsumerEntity();
        consumerEntity.setName(node.get("name").asText());
        consumerEntity.setMultipliedSum(
                String.valueOf((Integer) ((IntNode) node.get("sum")).numberValue() *
                        (Integer) ((IntNode) node.get("multiplier")).numberValue()));
        return consumerEntity;
    }
}