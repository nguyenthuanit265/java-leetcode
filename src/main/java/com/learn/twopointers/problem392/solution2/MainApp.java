package com.learn.twopointers.problem392.solution2;

import java.util.Objects;

//Title: 392. Is Subsequence
//Link: https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
public class MainApp {
    public static boolean isSubsequence(String s, String t) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            if (s.length() > t.length()) {
                return false;
            }

            String[] sArr = s.split("");
            String[] tArr = t.split("");
            int indexS = 0;
            int indexT = 0;
            while (indexT < tArr.length && indexS < sArr.length) {
                if (Objects.equals(tArr[indexT], sArr[indexS])) {
                    if (indexS == sArr.length - 1) {
                        return true;
                    }
                    indexT++;
                    indexS++;
                } else {
                    indexT++;
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
