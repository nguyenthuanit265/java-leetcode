package com.learn.leetcode75.problem151;

import java.util.Stack;

public class MainApp {

    public static String reverseWords(String s) {
        String[] words = s.strip().split(" ");
        int l = 0, r = words.length - 1;
        while (l <= r) {
            if (words[l].isEmpty()) {
                l++;
            }
            if (words[r].isEmpty()) {
                r--;
            }
            String temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
        }

        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                builder.append(word).append(" ");
            }
        }

        return builder.toString().strip();
    }


    public static String reverseWords2(String s) {
        String[] words = s.strip().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                builder.append(words[i]).append(" ");
            }
        }

        return builder.toString().strip();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords2("the sky is blue"));
        System.out.println(reverseWords2("  hello world  "));
        System.out.println(reverseWords2("a good   example"));
    }
}
