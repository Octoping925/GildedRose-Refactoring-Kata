package com.gildedrose.qualityupdater;

import com.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredQualityUpdaterTest {
    private static final String CONJURED = "Conjured Mana Cake";
    private static final QualityUpdater updater = new ConjuredQualityUpdater();

    @Test
    @DisplayName("시간이 지날 때마다 quality가 2씩 감소한다")
    void qualityReduceDoubleTest() {
        // given
        Item conjured = new Item(CONJURED, 1, 3);

        // when
        updater.updateQuality(conjured);

        // then
        assertThat(conjured.quality).isEqualTo(1);
    }

    @Test
    @DisplayName("sellIn이 0보다 작을 때에는 quality가 4씩 감소한다")
    void qualityReduceDoubleAfterSellInTest() {
        // given
        Item conjured = new Item(CONJURED, 0, 5);

        // when
        updater.updateQuality(conjured);

        // then
        assertThat(conjured.quality).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "0, 0", "1, 1", "-1, 0", "-1, 2"})
    @DisplayName("퀄리티는 0보다 작아지지 않는다")
    void qualityMinTest(int sellIn, int quality) {
        // given
        Item conjured = new Item(CONJURED, sellIn, quality);

        // when
        updater.updateQuality(conjured);

        // then
        assertThat(conjured.quality).isZero();
    }
}
