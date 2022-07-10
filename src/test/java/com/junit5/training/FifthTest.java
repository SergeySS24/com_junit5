package com.junit5.training;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.junit5.domain.EnumFromForth;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FifthTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @ValueSource(strings = {"рубашка",
                            "джинсы"})

    @ParameterizedTest(name = "Ввод слова {0}")
    void findItems(String alfa) {
        Selenide.open("https://piter.allithave.ru/");

        $(".flex-grow-1").setValue(alfa);
        $(".pr-lg-3").click();
        $$(".flex-grow-1").find(Condition.text(alfa)).shouldBe(Condition.visible);
    }

    @EnumSource(EnumFromForth.class)
    @ParameterizedTest(name = "Проверка Enum {0}")
    void checkTopBar(EnumFromForth alfa){
        Selenide.open("https://piter.allithave.ru/");

        $(".flex-grow-1").setValue("Галстук");
        $(".pr-lg-3").click();
        $$(".flex-grow-1").find(Condition.text(alfa.menuItems)).shouldBe(Condition.visible);
    }
}
