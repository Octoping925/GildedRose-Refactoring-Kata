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

    @Nested
    @DisplayName("Aged Brie는")
    class AgedBrieTest {
        @Test
        @DisplayName("시간이 지날 수록 quality가 증가한다")
        void agedBrieQualityIncreaseTest() {
            // given
            Item item = new Item("Aged Brie", 1, 1);

            // when
            GildedRose app = new GildedRose(new Item[]{item});
            app.updateQuality();

            // then
            assertThat(item.quality).isEqualTo(2);
        }

        @Test
        @DisplayName("퀄리티를 50을 넘기면서 증가하지는 않는다")
        void agedBrieQualityMaxTest() {
            // given
            Item item = new Item("Aged Brie", 1, 50);

            // when
            GildedRose app = new GildedRose(new Item[]{item});
            app.updateQuality();

            // then
            assertThat(item.quality).isEqualTo(50);
        }
    }

    @Nested
    @DisplayName("Sulfuras는")
    class SulfurasTest {
        private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

        @Test
        @DisplayName("시간이 지나도 quality가 변하지 않는다")
        void qualityNotReduceTest() {
            // given
            Item sulfuras = new Item(SULFURAS, 1, 80);

            // when
            GildedRose app = new GildedRose(new Item[]{sulfuras});
            app.updateQuality();

            // then
            assertThat(sulfuras.quality).isEqualTo(80);
        }
    }

    @Nested
    @DisplayName("Backstage passes는")
    class BackstagePassesTest {
        private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

        @Test
        @DisplayName("SellIn 값이 10일 전까지는 1씩 증가한다")
        void sellInBefore10Test() {
            // given
            Item backStagePasses = new Item(BACKSTAGE_PASSES, 11, 1);

            // when
            GildedRose app = new GildedRose(new Item[]{backStagePasses});
            app.updateQuality();

            // then
            assertThat(backStagePasses.sellIn).isEqualTo(10);
            assertThat(backStagePasses.quality).isEqualTo(2);
        }

        @Test
        @DisplayName("SellIn 값이 10일부터 5일 전까지는 2씩 증가한다")
        void sellInBefore5Test() {
            // given
            Item backStagePasses = new Item(BACKSTAGE_PASSES, 10, 1);

            // when
            GildedRose app = new GildedRose(new Item[]{backStagePasses});
            app.updateQuality();

            // then
            assertThat(backStagePasses.sellIn).isEqualTo(9);
            assertThat(backStagePasses.quality).isEqualTo(3);
        }

        @Test
        @DisplayName("SellIn 값이 5일부터 0일 전까지는 3씩 증가한다")
        void sellInBeforeStartTest() {
            // given
            Item backStagePasses = new Item(BACKSTAGE_PASSES, 5, 1);

            // when
            GildedRose app = new GildedRose(new Item[]{backStagePasses});
            app.updateQuality();

            // then
            assertThat(backStagePasses.sellIn).isEqualTo(4);
            assertThat(backStagePasses.quality).isEqualTo(4);
        }

        @Test
        @DisplayName("SellIn 값이 0일이 되면 quality는 0이 된다")
        void sellInEndTest() {
            // given
            Item backStagePasses = new Item(BACKSTAGE_PASSES, 0, 50);

            // when
            GildedRose app = new GildedRose(new Item[]{backStagePasses});
            app.updateQuality();

            // then
            assertThat(backStagePasses.sellIn).isEqualTo(-1);
            assertThat(backStagePasses.quality).isZero();
        }
    }

}
