package com.junit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.junit5.domain.MenuItem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebTest {

    @ValueSource(strings = {
            "Selenide",
            "JUnit"
    })
    @Disabled
    @ParameterizedTest(name = "проверка поиска в Яндексе по слову {0}")
    void yandexSearchTest(String testData) {
        //Предусловия:
        Selenide.open("https://www.yandex.ru");

        //Шаги:
        $("#text").setValue(testData);
        $("button[type='submit']").click();

        //Ожидаемый результат:
       $$(".serp-item").find(Condition.text(testData)).shouldBe(Condition.visible);
    }



    @CsvSource(value = {
            "Selenide| is an open source library for test",
            "JUnit| Support JUnit"
    },
    delimiter = '|')

    @ParameterizedTest(name = "проверка поиска в Яндексе по слову {0}, ожидаем результат: {1}")
    void yandexSearchComplexTest(String testData, String expectedResult) {
        //Предусловия:
        Selenide.open("https://www.yandex.ru");

        //Шаги:
        $("#text").setValue(testData);
        $("button[type='submit']").click();

        //Ожидаемый результат:
        $$(".serp-item").find(Condition.text(expectedResult)).shouldBe(Condition.visible);
    }

    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("first string", List.of(42, 13)),
                Arguments.of("second string", List.of(1, 2))
        );
    }

    @MethodSource("methodSourceExampleTest")
    @ParameterizedTest
    void methodSourceExampleTest(String first, List<Integer> second) {
        System.out.println(first + " and list: " + second);
    }

    @EnumSource(MenuItem.class)
    @ParameterizedTest()
    void yandexSearchMenuTest(MenuItem testData) {
        //Предусловия:
        Selenide.open("https://www.yandex.ru");

        //Шаги:
        $("#text").setValue("Allure TestOps");
        $("button[type='submit']").click();

        //Ожидаемый результат:
        $$(".navigation__item").find(Condition.text(testData.rusName))
                .click();

        Assertions.assertEquals(
                2,
                WebDriverRunner.getWebDriver().getWindowHandles().size()
        );
    }

    @AfterEach
    void close() {
        Selenide.closeWebDriver();
    }
}
