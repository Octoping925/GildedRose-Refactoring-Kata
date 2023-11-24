package com.gildedrose.qualityupdater;

import com.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BackstagePassesQualityUpdater 클래스")
class BackstagePassesQualityUpdaterTest {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final QualityUpdater updater = new BackstagePassesQualityUpdater();

    @Test
    @DisplayName("SellIn 값이 10일 전까지는 1씩 증가한다")
    void sellInBefore10Test() {
        // given
        Item backStagePasses = new Item(BACKSTAGE_PASSES, 11, 1);

        // when
        updater.updateQuality(backStagePasses);

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
        updater.updateQuality(backStagePasses);

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
        updater.updateQuality(backStagePasses);

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
        updater.updateQuality(backStagePasses);

        // then
        assertThat(backStagePasses.sellIn).isEqualTo(-1);
        assertThat(backStagePasses.quality).isZero();
    }

}
