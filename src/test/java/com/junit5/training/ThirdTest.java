package com.junit5.training;

import com.beust.jcommander.Strings;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ThirdTest {

    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.joom.com/ru");
        $(".layout____AvyJ").shouldBe(Condition.visible);
        $(".close___ukMoE").click();
    }

    @CsvSource(value = { "рубашка| Фонарь Рукава",
            "джинсы| Женские стильные свободные брюки"},
            delimiter = '|')


    @ParameterizedTest(name = "Поиск по слову {0}, вывод результата {1)")
    void findItems(String cloth, String expectedResult) {

        Selenide.open("https://www.joom.com/ru");
        $(".input___QjcpQ").setValue(cloth);
        $(".submit___AGVA6").click();
        $$(".name___vIcd9").find(Condition.text(expectedResult));
    }



}


