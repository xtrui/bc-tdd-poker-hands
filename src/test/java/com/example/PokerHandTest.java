package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTest {

    @Test
    void should_return_straight_when_get_type_given_3H4H5H6H7H() {
        //given
        String pokerCombination = "3H4H5H6H7H";
        PokerHand pokerHand = new PokerHand();
        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);
        //then
        assertEquals("Straight flush", combinationType);
    }
}
