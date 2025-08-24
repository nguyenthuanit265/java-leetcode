package com.learn.leetcode75.problem1768;

public class MainApp {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] a1 = word1.split("");
        String[] a2 = word2.split("");
        int i = 0, j = 0;
        while (i < a1.length && j < a2.length) {
            stringBuilder.append(a1[i]).append(a2[j]);
            i++;
            j++;
        }

        while (i < a1.length) {
            stringBuilder.append(a1[i++]);
        }
        while (j < a2.length) {
            stringBuilder.append(a2[j++]);
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }
}
