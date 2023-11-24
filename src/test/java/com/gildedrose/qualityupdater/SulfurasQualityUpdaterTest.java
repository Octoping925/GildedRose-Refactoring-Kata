package com.gildedrose.qualityupdater;

import com.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SulfurasQualityUpdaterTest {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final QualityUpdater updater = new SulfurasQualityUpdater();

    @Test
    @DisplayName("시간이 지나도 sellIn이 변하지 않는다")
    void sellInNotReduceTest() {
        // given
        Item sulfuras = new Item(SULFURAS, 1, 80);

        // when
        updater.updateQuality(sulfuras);

        // then
        assertThat(sulfuras.sellIn).isEqualTo(1);
    }

    @Test
    @DisplayName("시간이 지나도 quality가 변하지 않는다")
    void qualityNotReduceTest() {
        // given
        Item sulfuras = new Item(SULFURAS, 1, 80);

        // when
        updater.updateQuality(sulfuras);

        // then
        assertThat(sulfuras.quality).isEqualTo(80);
    }
}
