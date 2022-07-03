package com.junit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebTest {

    @ValueSource(strings = {
            "Selenide",
            "JUnit"
    })
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


}
