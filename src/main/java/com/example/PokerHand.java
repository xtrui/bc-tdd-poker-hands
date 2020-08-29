package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerHand {
    public CombinationType getCombinationType(String pokerCombination) {
        boolean isFlush = false;
        List<String> pokers = Arrays.asList(pokerCombination.split(""));
        List<String> numberStrCollect = new ArrayList<>();


        HashSet<String> charSet = new HashSet<>();
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
                return CombinationType.STRAIGHT_FLUSH;
            }
        }

        Map<Integer, Long> result = numberCollect.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));
        if (result.containsValue(4L)) {
            return CombinationType.FOUR_OF_A_KIND;
        }
        if (result.containsValue(3L) && result.containsValue(2L)) {
            return CombinationType.FULL_HOUSE;
        }
        if (isFlush) {
            return CombinationType.FLUSH;
        }

        if (isStraight(numberCollect)) {
            return CombinationType.STRAIGHT;
        }

        if (result.containsValue(3L)) {
            return CombinationType.THREE_OF_A_KIND;
        }
        if (result.containsValue(2L) && result.size() == 3) {
            return CombinationType.TWO_PAIR;
        }
        if (result.containsValue(2L)) {
            return CombinationType.PAIR;
        }

        return CombinationType.HIGH_CARD;
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
