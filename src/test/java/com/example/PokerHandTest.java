package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTest {

    @Test
    void should_return_straight_when_get_combination_type_given_3H4H5H6H7H() {
        //given
        String pokerCombination = "3H4H5H6H7H";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Straight flush", combinationType);
    }

    @Test
    void should_return_four_a_kind_when_get_combination_type_given_3H3D3S5C3D() {
        //given
        String pokerCombination = "3H3D3S5C3D";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Four of a kind", combinationType);
    }

    @Test
    void should_return_full_house_when_get_combination_type_given_3H3D3S5C3D() {
        //given
        String pokerCombination = "3H3D5S5C3D";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Full House", combinationType);
    }

    @Test
    void should_return_flush_when_get_combination_type_given_2H3H5H9HKH() {
        //given
        String pokerCombination = "2H3H5H9HKH";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Flush", combinationType);
    }
}
