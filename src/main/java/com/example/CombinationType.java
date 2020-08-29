package com.example;

/**
 * @author TIANRUI
 */

public enum CombinationType {
    HIGH_CARD("High Card", 1),
    PAIR("Pair", 2),
    TWO_PAIR("Two Pairs", 3),
    THREE_OF_A_KIND("Three of a Kind", 4),
    STRAIGHT("Straight", 5),
    FLUSH("Flush", 6),
    FULL_HOUSE("Full House", 7),
    FOUR_OF_A_KIND("Four of a kind", 8),
    STRAIGHT_FLUSH("Straight flush", 9);

    String type;
    int level;

    CombinationType(String type, int level) {
        this.type = type;
        this.level = level;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
