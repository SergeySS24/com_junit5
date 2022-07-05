package com.junit5.training;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 700;
    }


    @DisplayName("проверка выдачи результатов по слову Смеситель в Максидоме")
    @Test
    void simpleTest() {
        Selenide.open("https://www.maxidom.ru");


        //$(By.className("search__input")).setValue("Смеситель");
        //$("#q").setValue("table");
        //$(".search__submit").click();
        $(By.className("search__submit")).click();

    }

    @AfterAll
    static void close() {
       Configuration.timeout = 700;
       }

}
