package com.gildedrose.qualityupdater;

import com.gildedrose.Item;

public class NormalItemQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        reduceSellIn(item);
        reduceQuality(item);
    }

    private void reduceSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void reduceQuality(Item item) {
        if (item.quality == 0) {
            return;
        }

        item.quality -= calculateReduceQualityAmount(item);
    }

    private int calculateReduceQualityAmount(Item item) {
        if (item.sellIn >= 0) {
            return 1;
        }

        return Math.min(item.quality, 2);
    }
}
