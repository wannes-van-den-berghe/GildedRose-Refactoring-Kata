package com.gildedrose;

public class GildedRose {
    /* Items */
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    /* Qualifiers */
    private static final String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    item.quality++;
                    if (item.quality > 50) {
                        item.quality = 50;
                    }
                    break;
                case BACKSTAGE_PASSES:
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    } else if (item.sellIn <= 5) {
                        item.quality += 3;
                    } else if (item.sellIn <= 10) {
                        item.quality += 2;
                    } else {
                        item.quality += 1;
                    }
                    if (item.quality > 50) {
                        item.quality = 50;
                    }
                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    break;
                default:
                    int change = 1;
                    if (item.name.startsWith(CONJURED)) {
                        change = 2;
                    }

                    if (item.sellIn >= 0) {
                        item.quality -= change;
                    } else {
                        item.quality -= change * 2;
                    }
                    if (item.quality < 0) {
                        item.quality = 0;
                    }
                    break;
            }

            item.sellIn--;
        }
    }
}