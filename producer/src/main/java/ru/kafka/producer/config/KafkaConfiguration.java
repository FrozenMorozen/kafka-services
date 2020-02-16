package ru.kafka.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.kafka.producer.dto.model.SomethingEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
@Configuration
public class KafkaConfiguration {

    private static final Properties KAFKA_PROPERTIES = getProperties();

    static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(KafkaConfiguration.class.getClassLoader().getResourceAsStream("kafka.properties"));
            return properties;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return properties;
        }
    }

    @Bean
    ProducerFactory<String, SomethingEntity> createProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_PROPERTIES.getProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG));
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, SomethingEntity> kafkaTemplate() {
        return new KafkaTemplate<>(createProducerFactory());
    }


}
