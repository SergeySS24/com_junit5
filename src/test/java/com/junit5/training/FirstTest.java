package com.junit5.training;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {"Смеситель",
                            "Ламинат"})


    @ParameterizedTest
    @DisplayName("проверка выдачи результатов по слову Смеситель в Петровиче")
    @Test
    void simpleTest(String testData) {
        //Предусловия
        Selenide.open("https://petrovich.ru/");

        //Шаги
        $(By.className("header-search-input")).setValue(testData);
        $(By.className("pt-btn-fullheight___W5w5D")).click();


        $(By.className("header-search-input")).shouldHave(Condition.text(testData)).shouldBe(Condition.visible);

    }


    @Disabled
    @DisplayName("проверка выдачи результатов по слову Смеситель в Леруа")
    @Test
    void simpleTestLeroy() {
        Selenide.open("https://leroymerlin.ru");


    }


}
