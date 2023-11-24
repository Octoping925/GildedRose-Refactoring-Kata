package com.gildedrose.qualityupdater;

import com.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("NormalItem의 QualityUpdater는")
class NormalItemQualityUpdaterTest {
    private static final QualityUpdater updater = new NormalItemQualityUpdater();

    @Test
    @DisplayName("아이템은 하루가 지날 때 sellIn이 감소한다")
    void sellInReduceTest() {
        // given
        Item item = new Item("foo", 1, 1);

        // when
        updater.updateQuality(item);

        // then
        assertThat(item.sellIn).isZero();
    }

    @Test
    @DisplayName("아이템은 하루가 지날 때 quality가 감소한다")
    void qualityReduceTest() {
        // given
        Item item = new Item("foo", 1, 1);

        // when
        updater.updateQuality(item);

        // then
        assertThat(item.sellIn).isZero();
    }

    @Test
    @DisplayName("아이템은 판매하는 나머지 일수가 없어지면, quality가 두 배로 감소한다")
    void qualityReduceDoubleTest() {
        // given
        Item item = new Item("foo", 0, 2);

        // when
        updater.updateQuality(item);

        // then
        assertThat(item.quality).isZero();
    }

    @ParameterizedTest
    @DisplayName("quality는 0보다 작아지지 않는다")
    @CsvSource(value = {"1, 0", "0, 0", "-1, 0", "-1, 1"})
    void qualityMinTest(int sellIn, int quality) {
        // given
        Item item = new Item("foo", sellIn, quality);

        // when
        updater.updateQuality(item);

        // then
        assertThat(item.quality).isZero();
    }

}
