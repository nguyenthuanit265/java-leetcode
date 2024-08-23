package com.learn.twopointers.problem392.solution1;

//Title: 392. Is Subsequence
//Link: https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
public class MainApp {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int index = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(index)) {
                index++;
                if (index == s.length()) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("acb", "ahbgdc")); // false
    }
}
