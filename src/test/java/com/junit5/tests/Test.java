package com.junit5.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.junit5.domain.TestEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Test {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    //Тест№1
    @ValueSource(strings = {"рубашка",
                            "джинсы"})

    @ParameterizedTest(name = "Поиск по слову {0}")
    void searchItems(String goods) {
        //Предусловие
        Selenide.open("https://piter.allithave.ru/");

        //Шаги
        $(".flex-grow-1").setValue(goods);
        $(".pr-lg-3").click();

        //Ожидаемый результат
        $$(".flex-grow-1").find(Condition.text(goods)).shouldBe(Condition.visible);
    }

    //Тест№2
    @CsvSource(value = {"костюм| Костюм зимний «Эхо»",
    "ботинки| Ботинки лыжные TREK Snowball"},
    delimiter = '|')

    @ParameterizedTest (name = "Поиск по слову {0}")
    void searchItemsWithCards(String searchWord, String expectedResult) {
        //Предусловие
        Selenide.open("https://piter.allithave.ru/");

        //Шаги
        $(".flex-grow-1").setValue(searchWord);
        $(".pr-lg-3").click();

        //Ожидаемый результат
        $$(".flex-grow-1").find(Condition.text(expectedResult)).shouldBe(Condition.visible);
    }

    //Тест№3 // 
    @EnumSource(TestEnum.class)
    @ParameterizedTest(name = "Проверка закрепленных значений в topbar {0}")
    void checkPermanentValues(TestEnum charlie) {
        Selenide.open("https://piter.allithave.ru/");
        $$(".flex-grow-1").find(Condition.text(charlie.topBar)).shouldBe(Condition.visible);
    }
}
