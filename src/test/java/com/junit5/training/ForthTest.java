package com.junit5.training;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ForthTest {

    @BeforeAll
    static void settingUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }


    @CsvSource(value = {"рубашка| Рубашка мужская ALLITHAVE",
                            "джинсы| Джинсы женские, размер 44"},
    delimiter = '|')

    @Disabled
    @ParameterizedTest(name = "Проверяем {0}")
    void findItem(String clothes, String expectedResult) {
        Selenide.open("https://piter.allithave.ru/");

        $(".flex-grow-1").setValue(clothes);
        $(".pr-lg-3").click();
        $$(".flex-grow-1").find(Condition.text(expectedResult)).shouldBe(Condition.visible);
    }


}
