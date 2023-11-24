package com.gildedrose;

import com.gildedrose.qualityupdater.QualityUpdater;
import com.gildedrose.qualityupdater.QualityUpdaterFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdater qualityUpdater = QualityUpdaterFactory.getQualityUpdater(item.name);
            qualityUpdater.updateQuality(item);
        }
    }
}
