package ru.kafka.consumer.dto.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import ru.kafka.consumer.dao.model.ConsumerDaoEntity;
import ru.kafka.consumer.dto.model.ConsumerModel;

import java.io.IOException;

public class ConsumerDaoEntityDeserializer extends StdDeserializer<ConsumerDaoEntity> {

    public ConsumerDaoEntityDeserializer() {
        this(null);
    }

    public ConsumerDaoEntityDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ConsumerDaoEntity deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        ConsumerDaoEntity consumerDaoEntity = new ConsumerDaoEntity();
        consumerDaoEntity.setName(node.get("name").asText());
        consumerDaoEntity.setSum(((IntNode) node.get("sum")).longValue());
        consumerDaoEntity.setMultiplier(((IntNode) node.get("multiplier")).longValue());


        /*ConsumerModel consumerModel = new ConsumerModel();
        consumerModel.setName(node.get("name").asText());
        consumerModel.setMultipliedSum(
                String.valueOf((Integer) ((IntNode) node.get("sum")).numberValue() *
                        (Integer) ((IntNode) node.get("multiplier")).numberValue()));*/
        return consumerDaoEntity;
    }
}