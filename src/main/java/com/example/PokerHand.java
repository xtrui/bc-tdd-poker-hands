package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand {


    public String getCombinationType(String pokerCombination) {
        //
        List<String> pokers = Arrays.asList(pokerCombination.split(""));
        List<Integer> numberCollect = pokers.stream()
                .filter(pokerChar -> Character.isDigit(pokerChar.charAt(0)))
                .sorted()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<String> charCollect = pokers.stream()
                .filter(pokerChar -> !Character.isDigit(pokerChar.charAt(0)))
                .collect(Collectors.toList());
        //

        HashSet<String> strings = new HashSet<>(charCollect);
        if (strings.size() == 1) {
            for (int i = 1; i < numberCollect.size(); i++) {
                if (numberCollect.get(i - 1) + 1 != numberCollect.get(i)) {
                    return "no";
                }
            }
            return "Straight flush";
        }

        System.out.println(numberCollect);
        System.out.println(charCollect);
        return "ok";
    }
}
