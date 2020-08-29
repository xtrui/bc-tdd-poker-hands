package com.example;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please Input:");
        System.out.println("example:");
        System.out.println("Black:2H 4S 4C 2D 4H White:2S 8S AS QS 3S");
        System.out.println("the program is happy path,do not check input,please input correctly");
        System.out.println("input exit() to exit");
        String playStr;
        while (true) {
            playStr = scanner.nextLine();
            if (Objects.equals(playStr, "exit")) {
                break;
            }
            //此处添加正则检查输入
            String black = playStr.substring(playStr.indexOf(":") + 1, playStr.indexOf("White:")).replace(" ", "");
            String white = playStr.substring(playStr.lastIndexOf(":") + 1).replace(" ", "");
            PokerHand pokerHand = new PokerHand();
            CombinationType blackCombinationType = pokerHand.getCombinationType(black);
            Map<Integer, Long> blackResult = pokerHand.getResult();
            CombinationType whiteCombinationType = pokerHand.getCombinationType(white);
            Map<Integer, Long> whiteResult = pokerHand.getResult();
            if (blackCombinationType.level > whiteCombinationType.level) {
                System.out.println("Black win. - with " + blackCombinationType.type);
            } else if (blackCombinationType.level < whiteCombinationType.level) {
                System.out.println("White win. - with " + blackCombinationType.type);
            } else {
                judgeWhenSaveLevel(blackResult, whiteResult);
                System.out.println(" " + blackCombinationType.type);
            }
        }
    }

    private static void judgeWhenSaveLevel(Map<Integer, Long> blackResult, Map<Integer, Long> whiteResult) {
        ArrayList<Integer> blackList = new ArrayList<>(new TreeSet<>(blackResult.keySet()));
        ArrayList<Integer> whiteList = new ArrayList<>(new TreeSet<>(whiteResult.keySet()));
        for (int i = blackList.size() - 1; i >= 0; i--) {
            if (blackList.get(i) > whiteList.get(i)) {
                System.out.print("Black win. - with");
                return;
            }
            if (blackList.get(i) < whiteList.get(i)) {
                System.out.print("White win. - with");
                return;
            }
        }
        System.out.print("Pie. - with");
    }

    public String run() {
        return "ABC";
    }
}
