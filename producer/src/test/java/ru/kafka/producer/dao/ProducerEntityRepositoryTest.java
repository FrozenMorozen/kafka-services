package ru.kafka.producer.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kafka.producer.dao.mock.ProducerEntityRepositoryMock;

import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProducerEntityRepositoryTest {

    private ProducerEntityRepository producerEntityRepository = new ProducerEntityRepositoryMock();

    @ParameterizedTest
    @MethodSource("idDataProvider")
    @DisplayName("producerEntityRepository.getDataForId(UUID uuid) : тест с рандомным UUID")
    void getDataForId(UUID uuid) {
        assertNotNull(producerEntityRepository.getDataForId(uuid));
    }

    @Test
    @DisplayName("producerEntityRepository.getDataForId(UUID uuid) : тест с параметром null")
    void getDataForNullId() {
        assertNull(producerEntityRepository.getDataForId(null));
    }

    private static Stream<Arguments> idDataProvider() {
        return Stream.of(
                Arguments.of(UUID.randomUUID()),
                Arguments.of(UUID.randomUUID())
        );
    }

}