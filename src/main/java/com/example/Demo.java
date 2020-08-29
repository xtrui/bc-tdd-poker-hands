package com.example;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(CombinationType.values()));
        System.out.println(CombinationType.FLUSH.ordinal());
    }

    public String run() {
        return "ABC";
    }
}
