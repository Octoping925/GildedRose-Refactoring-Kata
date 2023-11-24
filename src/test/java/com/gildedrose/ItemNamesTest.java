package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ItemNames 클래스는")
class ItemNamesTest {
    @ParameterizedTest
    @MethodSource("itemNameProvider")
    @DisplayName("of 메소드로 ItemNames 인스턴스를 생성할 수 있다")
    void ofTest(String name, ItemNames expected) {
        // when
        ItemNames actual = ItemNames.of(name);

        // then
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> itemNameProvider() {
        return Stream.of(
            Arguments.of("Aged Brie", ItemNames.AGED_BRIE),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", ItemNames.BACKSTAGE_PASSES),
            Arguments.of("Sulfuras, Hand of Ragnaros", ItemNames.SULFURAS),
            Arguments.of("foo", ItemNames.NORMAL_ITEM)
        );
    }
}
