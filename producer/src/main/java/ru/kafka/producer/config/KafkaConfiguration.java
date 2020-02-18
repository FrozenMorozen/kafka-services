package ru.kafka.producer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import ru.kafka.producer.dto.model.ProducerModel;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaConfiguration {

    private KafkaProperties kafkaProperties;

    public KafkaConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    ProducerFactory<String, ProducerModel> createProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                !kafkaProperties.getBootstrapServers().isEmpty() ? kafkaProperties.getBootstrapServers().get(0) : null);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getProducer().getValueSerializer());
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, ProducerModel> kafkaTemplate() {
        KafkaTemplate<String, ProducerModel> template = new KafkaTemplate<>(createProducerFactory());
        template.setDefaultTopic(kafkaProperties.getTemplate().getDefaultTopic());
        return template;
    }

}