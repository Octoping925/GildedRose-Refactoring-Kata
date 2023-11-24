package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].name).isEqualTo("fixme");
    }

    @Test
    @DisplayName("아이템은 하루가 지날 때 sellIn이 감소한다")
    void sellInReduceTest() {
        // given
        Item item = new Item("foo", 1, 1);

        // when
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        // then
        assertThat(item.sellIn).isZero();
    }

    @Test
    @DisplayName("아이템은 하루가 지날 때 quality가 감소한다")
    void qualityReduceTest() {
        // given
        Item item = new Item("foo", 1, 1);

        // when
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        // then
        assertThat(item.sellIn).isZero();
    }

    @Test
    @DisplayName("아이템은 판매하는 나머지 일수가 없어지면, quality가 두 배로 감소한다")
    void qualityReduceDoubleTest() {
        // given
        Item item = new Item("foo", 0, 2);

        // when
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        // then
        assertThat(item.quality).isZero();
    }
}
