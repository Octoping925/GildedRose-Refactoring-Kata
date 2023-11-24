package com.gildedrose.qualityupdater;

import com.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Aged Brie의 QualityUpdater는")
class AgedBrieQualityUpdaterTest {
    private static final QualityUpdater updater = new AgedBrieQualityUpdater();

    @Test
    @DisplayName("시간이 지날 수록 quality가 증가한다")
    void agedBrieQualityIncreaseTest() {
        // given
        Item item = new Item("Aged Brie", 1, 1);

        // when
        updater.updateQuality(item);

        // then
        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    @DisplayName("퀄리티를 50을 넘기면서 증가하지는 않는다")
    void agedBrieQualityMaxTest() {
        // given
        Item item = new Item("Aged Brie", 1, 50);

        // when
        updater.updateQuality(item);

        // then
        assertThat(item.quality).isEqualTo(50);
    }
}
