package com.gildedrose.qualityupdater;

import com.gildedrose.Item;

public class AgedBrieQualityUpdater implements QualityUpdater {
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
        if (item.quality >= 50) {
            return  0;
        }

        return 1;
    }

}
