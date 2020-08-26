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

    @Test
    void should_return_four_a_kind_when_get_type_given_3H3D3S5C3D() {
        //given
        String pokerCombination = "3H3D3S5C3D";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Four of a kind", combinationType);
    }
}
