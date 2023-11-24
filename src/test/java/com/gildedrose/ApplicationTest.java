package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class ApplicationTest {
    @DisplayName("프로그램이 정상적으로 작동하는지 확인한다")
    @Test
    void test() {
        // given
        Item[] items = {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 1, 6),
        };

        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();
        checkFirstDay(items);

        app.updateQuality();
        checkSecondDay(items);
    }


    private void checkFirstDay(Item[] items) {
        assertSoftly(softly -> {
            softly.assertThat(items[0].sellIn).isEqualTo(9);
            softly.assertThat(items[0].quality).isEqualTo(19);

            softly.assertThat(items[1].sellIn).isEqualTo(1);
            softly.assertThat(items[1].quality).isEqualTo(1);

            softly.assertThat(items[2].sellIn).isEqualTo(4);
            softly.assertThat(items[2].quality).isEqualTo(6);

            softly.assertThat(items[3].sellIn).isZero();
            softly.assertThat(items[3].quality).isEqualTo(80);

            softly.assertThat(items[4].sellIn).isEqualTo(-1);
            softly.assertThat(items[4].quality).isEqualTo(80);

            softly.assertThat(items[5].sellIn).isEqualTo(14);
            softly.assertThat(items[5].quality).isEqualTo(21);

            softly.assertThat(items[6].sellIn).isEqualTo(9);
            softly.assertThat(items[6].quality).isEqualTo(50);

            softly.assertThat(items[7].sellIn).isEqualTo(4);
            softly.assertThat(items[7].quality).isEqualTo(50);

            softly.assertThat(items[8].sellIn).isEqualTo(0);
            softly.assertThat(items[8].quality).isEqualTo(4);
        });
    }

    private void checkSecondDay(Item[] items) {
        assertSoftly(softly -> {
            softly.assertThat(items[0].sellIn).isEqualTo(8);
            softly.assertThat(items[0].quality).isEqualTo(18);

            softly.assertThat(items[1].sellIn).isEqualTo(0);
            softly.assertThat(items[1].quality).isEqualTo(2);

            softly.assertThat(items[2].sellIn).isEqualTo(3);
            softly.assertThat(items[2].quality).isEqualTo(5);

            softly.assertThat(items[3].sellIn).isZero();
            softly.assertThat(items[3].quality).isEqualTo(80);

            softly.assertThat(items[4].sellIn).isEqualTo(-1);
            softly.assertThat(items[4].quality).isEqualTo(80);

            softly.assertThat(items[5].sellIn).isEqualTo(13);
            softly.assertThat(items[5].quality).isEqualTo(22);

            softly.assertThat(items[6].sellIn).isEqualTo(8);
            softly.assertThat(items[6].quality).isEqualTo(50);

            softly.assertThat(items[7].sellIn).isEqualTo(3);
            softly.assertThat(items[7].quality).isEqualTo(50);

            softly.assertThat(items[8].sellIn).isEqualTo(-1);
            softly.assertThat(items[8].quality).isZero();
        });
    }
}
