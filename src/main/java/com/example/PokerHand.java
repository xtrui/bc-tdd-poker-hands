package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerHand {
    Map<Integer, Long> result;

    public Map<Integer, Long> getResult() {
        return result;
    }

    public void setResult(Map<Integer, Long> result) {
        this.result = result;
    }

    public CombinationType getCombinationType(String pokerCombination) {
        boolean isFlush = false;
        List<String> pokers = Arrays.asList(pokerCombination.split(""));
        List<String> numberStrCollect = getNumberStrCollect(pokers);
        Set<String> charSet = getCharSet(pokers);

        List<Integer> numberCollect = getNumberCollect(numberStrCollect);

        if (charSet.size() == 1) {
            isFlush = true;
            if (isStraight(numberCollect)) {
                return CombinationType.STRAIGHT_FLUSH;
            }
        }

        Map<Integer, Long> result = getPokerNumberMap(numberCollect);
        this.result = result;

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

    Map<Integer, Long> getPokerNumberMap(List<Integer> numberCollect) {
        Map<Integer, Long> result = numberCollect.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));
        return result;
    }

    private List<String> getNumberStrCollect(List<String> pokers) {
        List<String> numberStrCollect = new ArrayList<>();
        for (int i = 0; i < pokers.size(); i++) {
            if (i % 2 == 0) {
                numberStrCollect.add(pokers.get(i));
            }
        }
        return numberStrCollect;
    }

    Set<String> getCharSet(List<String> pokers) {
        HashSet<String> charSet = new HashSet<>();
        for (int i = 0; i < pokers.size(); i++) {
            if (i % 2 != 0) {
                charSet.add(pokers.get(i));
            }
        }
        return charSet;
    }

    private List<Integer> getNumberCollect(List<String> numberStrCollect) {
        return numberStrCollect.stream()
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
