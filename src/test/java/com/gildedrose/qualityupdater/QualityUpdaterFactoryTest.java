package com.gildedrose.qualityupdater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("QualityUpdaterFactory 클래스는")
class QualityUpdaterFactoryTest {
    @Nested
    @DisplayName("item의 이름에 따라 QualityUpdater를 생성할 수 있다")
    class GetQualityUpdaterTest {
        @DisplayName("Aged Brie의 경우 AgedBrieQualityUpdater를 생성한다")
        @Test
        void createAgedBrieTest() {
            // given
            String name = "Aged Brie";

            // when
            QualityUpdater updater = QualityUpdaterFactory.getQualityUpdater(name);

            // then
            assertThat(updater).isInstanceOf(AgedBrieQualityUpdater.class);
        }

        @Test
        @DisplayName("Backstage passes의 경우 BackstagePassesQualityUpdater를 생성한다")
        void createBackstagePassesTest() {
            // given
            String name = "Backstage passes to a TAFKAL80ETC concert";

            // when
            QualityUpdater updater = QualityUpdaterFactory.getQualityUpdater(name);

            // then
            assertThat(updater).isInstanceOf(BackstagePassesQualityUpdater.class);
        }

        @Test
        @DisplayName("Sulfuras의 경우 SulfurasQualityUpdater를 생성한다")
        void createSulfurasTest() {
            // given
            String name = "Sulfuras, Hand of Ragnaros";

            // when
            QualityUpdater updater = QualityUpdaterFactory.getQualityUpdater(name);

            // then
            assertThat(updater).isInstanceOf(SulfurasQualityUpdater.class);
        }

        @Test
        @DisplayName("나머지 경우 NormalItemQualityUpdater를 생성한다")
        void createTest() {
            // given
            String name = "foo";

            // when
            QualityUpdater updater = QualityUpdaterFactory.getQualityUpdater(name);

            // then
            assertThat(updater).isInstanceOf(NormalItemQualityUpdater.class);
        }
    }
}
