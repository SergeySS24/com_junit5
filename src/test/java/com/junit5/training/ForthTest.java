package com.junit5.training;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.junit5.domain.EnumFromForth;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ForthTest {

    @BeforeAll
    static void settingUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Disabled
    @CsvSource(value = {"рубашка| Рубашка мужская ALLITHAVE",
            "джинсы| Джинсы женские, размер 44"},
            delimiter = '|')


    @ParameterizedTest(name = "Проверяем {0}")
    void findItem(String clothes, String expectedResult) {
        Selenide.open("https://piter.allithave.ru/");

        $(".flex-grow-1").setValue(clothes);
        $(".pr-lg-3").click();
        $$(".flex-grow-1").find(Condition.text(expectedResult)).shouldBe(Condition.visible);
    }

    @ValueSource(strings = {"рубашка",
                            "галстук"})


    static Stream<Arguments> findItemWithMethod() {
        return Stream.of(
                Arguments.of("first string"),
                Arguments.of("second string")
        );
    }

    @MethodSource("findItemWithMethod")
    @ParameterizedTest(name = "checking MethodSource")
    void findItemWithMethod(String first, String second) {

    }
}

