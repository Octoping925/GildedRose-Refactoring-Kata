package com.gildedrose.qualityupdater;

import com.gildedrose.Item;

public class AgedBrieQualityUpdater implements QualityUpdater {
    private static final int MAX_QUALITY = 50;

    @Override
    public void updateQuality(Item item) {
        reduceSellIn(item);
        increaseQuality(item);
    }

    private void reduceSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality(Item item) {
        item.quality += calculateIncreaseQualityAmount(item);
    }

    private int calculateIncreaseQualityAmount(Item item) {
        if (item.quality >= MAX_QUALITY) {
            return 0;
        }

        return 1;
    }

}
