package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("AAA");
        set.add("BB");
        set.add("CCC");
        set.add("AAA");

        for (String el: set) {
            System.out.println(el);
        }

        String arr[] = {"AA", "BB", "AA"};
        Set<String> set1 = new HashSet<>(Arrays.asList(arr));
        System.out.println("----");
        for (String el: set1) System.out.println(el);
    }
}
