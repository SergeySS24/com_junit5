package com.junit5.training;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SecondTest {

    @BeforeAll
    static void preparation() {
       Configuration.browserSize = "1920x1080";
       Configuration.holdBrowserOpen = true;
   }


   @CsvSource({"lego, Конструктор Lego City",
                            "car, Нож яхтсмена"
   })



    @ParameterizedTest(name = "Поиск по слову {0}, ожидаем {1}")
    void startTest(String search, String expectedResult) {
       Selenide.open("https://piter.allithave.ru/");

       $(".flex-grow-1").setValue(search);
       $(".pr-2").click();
       $$(".flex-grow-1").find(Condition.text(expectedResult)).shouldHave(Condition.visible);

    }


}
