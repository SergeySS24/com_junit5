package com.junit5.training;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FirstTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = { "Смеситель",
                             "Ламинат"
    })

    @ParameterizedTest(name = "проверка выдачи результатов по слову {0} в Петровиче")
    void simpleTest(String testData) {
        //Предусловия
        Selenide.open("https://petrovich.ru");

        //Шаги
        $(By.className("header-search-input")).setValue(testData);
        $(By.className("pt-btn-fullheight___W5w5D")).click();


        $$(".header-search-input").find(Condition.text(testData));
        //$$(".header-search-input").find(Condition.text(testData)).shouldBe(Condition.visible) - почему visible не работатет?
        //$(By.className("header-search-input")).find(testData).shouldBe(Condition.visible); - вариант 2

    }



   // @DisplayName("проверка выдачи результатов по слову Смеситель в Леруа")
   // @Test
   // void simpleTestLeroy() {
   //     Selenide.open("https://leroymerlin.ru");


   // }


}
