package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerHand {


    public String getCombinationType(String pokerCombination) {
        boolean isFlush = false;
        //
        List<String> pokers = Arrays.asList(pokerCombination.split(""));
        List<String> numberStrCollect = new ArrayList<>();

//                pokers.stream()
//                .filter(pokerChar -> Character.isDigit(pokerChar.charAt(0)))
//                .sorted()
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
        HashSet<String> charSet = new HashSet<>();
//                pokers.stream()
//                .filter(pokerChar -> !Character.isDigit(pokerChar.charAt(0)))
//                .collect(Collectors.toCollection(HashSet::new));
        //
        for (int i = 0; i < pokers.size(); i++) {
            if (i % 2 == 0) {
                numberStrCollect.add(pokers.get(i));
            } else {
                charSet.add(pokers.get(i));
            }
        }

        List<Integer> numberCollect = numberStrCollect.stream()
                .map(numStr -> {
                    if (Objects.equals(numStr, "A")) {
                        return "14";
                    }
                    if (Objects.equals(numStr, "J")) {
                        return "11";
                    }
                    if (Objects.equals(numStr, "Q")) {
                        return "12";
                    }
                    if (Objects.equals(numStr, "K")) {
                        return "13";
                    }
                    return numStr;
                })
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (charSet.size() == 1) {
            isFlush = true;
            if (isStraight(numberCollect)) {
                return "Straight flush";
            }
        }

        Map<Integer, Long> result = numberCollect.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));
        if (result.containsValue(4L)) {
            return "Four of a kind";
        }
        if (result.containsValue(3L) && result.containsValue(2L)) {
            return "Full House";
        }
        if (isFlush) {
            return "Flush";
        }

        if (isStraight(numberCollect)) {
            return "Straight";
        }

        if (result.containsValue(3L)) {
            return "Three of a Kind";
        }

        return "ok";
    }

    private boolean isStraight(List<Integer> numberCollect) {
        for (int i = 1; i < numberCollect.size(); i++) {
            if (numberCollect.get(i - 1) + 1 != numberCollect.get(i)) {
                return false;
            }
        }
        return true;
    }
}
