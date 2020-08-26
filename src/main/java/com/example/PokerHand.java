package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
        HashSet<String> charSet = pokers.stream()
                .filter(pokerChar -> !Character.isDigit(pokerChar.charAt(0)))
                .collect(Collectors.toCollection(HashSet::new));
        //
        if (charSet.size() == 1) {
            //同花
            for (int i = 1; i < numberCollect.size(); i++) {
                if (numberCollect.get(i - 1) + 1 != numberCollect.get(i)) {
                    return "no";
                }
            }
            return "Straight flush";
        }

        Map<Integer, Long> result = numberCollect.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));
        if (result.containsValue(4L)) {
            return "Four of a kind";
        }

        return "ok";
    }
}
