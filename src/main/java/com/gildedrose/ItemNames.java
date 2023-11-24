package com.gildedrose;

import java.util.stream.Stream;

public enum ItemNames {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake"),
    NORMAL_ITEM("Normal Item"),
    ;

    private final String name;

    ItemNames(String name) {
        this.name = name;
    }

    public static ItemNames of(String name) {
        return Stream.of(ItemNames.values())
            .filter(itemNames -> itemNames.name.equals(name))
            .findFirst()
            .orElse(NORMAL_ITEM);
    }
}
