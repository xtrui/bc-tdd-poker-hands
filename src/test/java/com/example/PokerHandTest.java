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

    @Test
    void should_return_straight_when_get_combination_type_given_3H4D5S6C7D() {
        //given
        String pokerCombination = "3H4D5S6C7D";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Straight", combinationType);
    }

    @Test
    void should_return_three_of_a_kind_when_get_combination_type_given_3H3D5S9C3D() {
        //given
        String pokerCombination = "3H3D5S9C3D";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Three of a Kind", combinationType);
    }

    @Test
    void should_return_two_pairs_when_get_combination_type_given_3H3D5S9C5D() {
        //given
        String pokerCombination = "3H3D5S9C5D";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Two Pairs", combinationType);
    }

    @Test
    void should_return_pair_when_get_combination_type_given_3H3D5S9CKD() {
        //given
        String pokerCombination = "3H3D5S9CKD";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("Pair", combinationType);
    }

    @Test
    void should_return_High_Car_when_get_combination_type_given_3H2D5S9CKD() {
        //given
        String pokerCombination = "3H2D5S9CKD";
        PokerHand pokerHand = new PokerHand();

        //when
        String combinationType = pokerHand.getCombinationType(pokerCombination);

        //then
        assertEquals("High Card", combinationType);
    }

}
