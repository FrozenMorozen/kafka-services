package ru.kafka.consumer.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kafka.consumer.dao.model.ConsumerDaoEntity;
import ru.kafka.consumer.dto.converter.impl.ConsumerModelConverter;
import ru.kafka.consumer.dto.model.ConsumerModel;
import ru.kafka.consumer.service.impl.ConsumerServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerServiceTest {

    private static final String UUID_DEFAULT = "c08c9913-900d-460a-bcd9-4f397ede1397";
    private static final String NAME_DEFAULT = "somethingName";
    private static final Long SUM_DEFAULT = 456L;
    private static final Long MULTIPLIER_DEFAULT = 78L;
    private static final String MULTIPLIED_SUM_DEFAULT = String.valueOf(SUM_DEFAULT * MULTIPLIER_DEFAULT);

    private ConsumerService consumerService = new ConsumerServiceImpl(new ConsumerModelConverter());

    @ParameterizedTest
    @MethodSource("somethingActionDataProvider")
    @DisplayName("consumerService.somethingAction(String uuid, ConsumerDaoEntity consumerEntity) : тест ляля")
    void somethingAction(String uuid, ConsumerDaoEntity consumerDaoEntity, ConsumerModel expectedResult) {
        assertEquals(consumerService.somethingAction(uuid, consumerDaoEntity), expectedResult);
    }

    private static Stream<Arguments> somethingActionDataProvider() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of(null, new ConsumerDaoEntity(), new ConsumerModel()),
                Arguments.of(null,
                        createDaoWithParam(NAME_DEFAULT, SUM_DEFAULT, MULTIPLIER_DEFAULT),
                        createDtoWithParam(null, NAME_DEFAULT, MULTIPLIED_SUM_DEFAULT)),
                Arguments.of(UUID_DEFAULT,
                        createDaoWithParam(null, SUM_DEFAULT, MULTIPLIER_DEFAULT),
                        createDtoWithParam(UUID_DEFAULT, null, MULTIPLIED_SUM_DEFAULT)),
                Arguments.of(UUID_DEFAULT,
                        createDaoWithParam(NAME_DEFAULT, null, MULTIPLIER_DEFAULT),
                        createDtoWithParam(UUID_DEFAULT, NAME_DEFAULT, null)),
                Arguments.of(UUID_DEFAULT,
                        createDaoWithParam(NAME_DEFAULT, SUM_DEFAULT, null),
                        createDtoWithParam(UUID_DEFAULT, NAME_DEFAULT, null)),
                Arguments.of(UUID_DEFAULT,
                        createDaoWithParam(NAME_DEFAULT, SUM_DEFAULT, MULTIPLIER_DEFAULT),
                        createDtoWithParam(UUID_DEFAULT, NAME_DEFAULT, MULTIPLIED_SUM_DEFAULT))
        );
    }

    private static ConsumerModel createDtoWithParam(String uuid, String name, String multipliedSum) {
        ConsumerModel consumerModel = new ConsumerModel();
        consumerModel.setUuid(uuid);
        consumerModel.setName(name);
        consumerModel.setMultipliedSum(multipliedSum);
        return consumerModel;
    }

    private static ConsumerDaoEntity createDaoWithParam(String name, Long sum, Long multiplier) {
        ConsumerDaoEntity consumerDaoEntity = new ConsumerDaoEntity();
        consumerDaoEntity.setName(name);
        consumerDaoEntity.setSum(sum);
        consumerDaoEntity.setMultiplier(multiplier);
        return consumerDaoEntity;
    }
}
