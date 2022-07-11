package com.junit5.domain;

public enum TestEnum {
    ITEM1("Новинки"),
    ITEM2("Хиты продаж"),
    ITEM3("Скидки"),
    ITEM4("Новости"),
    ITEM5("Отзывы");

    public final String topBar;

    TestEnum(String topBar) {this.topBar = topBar;}

}
