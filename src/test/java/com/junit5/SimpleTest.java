package com.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс с демонстрационными тестами")
public class SimpleTest {

    @Disabled("Тест Альфа")
    @DisplayName("Демонстрационный тест")
    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2, "Проверяем что 3 > 2");
        Assertions.assertFalse(3 < 2);
        Assertions.assertEquals(1, 1);
        Assertions.assertAll(
                () -> Assertions.assertTrue(3 < 2),
                () -> Assertions.assertTrue(3 > 2)
        );

    }

}
