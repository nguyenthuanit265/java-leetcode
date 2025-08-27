package com.learn.leetcode75.problem345;

import java.util.*;

public class MainApp {
    public static String reverseVowels(String s) {
        List<String> vowels = new ArrayList<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        String[] arr = s.split("");
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String string : arr) {
            if (vowels.contains(string.toLowerCase())) {
                stack.add(string);
            }
        }

        for (String string : arr) {
            if (vowels.contains(string.toLowerCase())) {
                builder.append(stack.pop());
            } else {
                builder.append(string);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
}
