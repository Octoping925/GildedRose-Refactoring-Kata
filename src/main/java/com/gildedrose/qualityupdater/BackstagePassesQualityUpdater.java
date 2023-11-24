package com.gildedrose.qualityupdater;

import com.gildedrose.Item;

public class BackstagePassesQualityUpdater implements QualityUpdater {
    private static final int MAX_QUALITY = 50;

    @Override
    public void updateQuality(Item item) {
        reduceSellIn(item);
        increaseQuality(item);
    }

    private void reduceSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void increaseQuality(Item item) {
        item.quality += calculateIncreaseAmount(item);
    }

    private int calculateIncreaseAmount(Item item) {
        if(item.sellIn >= 10) {
            return Math.min(MAX_QUALITY - item.quality, 1);
        }

        if(item.sellIn > 5) {
            return Math.min(MAX_QUALITY - item.quality, 2);
        }

        if(item.sellIn >= 0) {
            return Math.min(MAX_QUALITY - item.quality, 3);
        }

        return -item.quality;
    }
}
