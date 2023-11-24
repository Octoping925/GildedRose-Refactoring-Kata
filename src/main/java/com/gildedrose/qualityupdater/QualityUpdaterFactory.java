package com.gildedrose.qualityupdater;

import com.gildedrose.ItemNames;

import java.util.Map;

public class QualityUpdaterFactory {
    private static final Map<ItemNames, QualityUpdater> QUALITY_UPDATER_MAP = Map.of(
            ItemNames.AGED_BRIE, new AgedBrieQualityUpdater(),
            ItemNames.BACKSTAGE_PASSES, new BackstagePassesQualityUpdater(),
            ItemNames.SULFURAS, new SulfurasQualityUpdater(),
            ItemNames.NORMAL_ITEM, new NormalItemQualityUpdater()
    );

    public static QualityUpdater getQualityUpdater(String itemName) {
        return QUALITY_UPDATER_MAP.get(ItemNames.of(itemName));
    }

    private QualityUpdaterFactory() {
    }
}
