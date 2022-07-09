package com.junit5.domain;

public enum EnumFromForth {
        ITEM1("Новинки"), ITEM2("Хиты продаж"), ITEM3("Скидки"),
        ITEM4("Новости"), ITEM5("Отзывы");

    public final String menuItems;

        EnumFromForth(String menuItems) {this.menuItems = menuItems;}


}
