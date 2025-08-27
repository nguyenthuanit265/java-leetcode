package com.learn.leetcode75.problem151;

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

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }
}
