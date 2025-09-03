package com.learn.leetcode75.slidingwindow.problem1456;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainApp {
    public static int maxVowels(String s, int k) {
        int res = 0, count = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        while (left < chars.length) {
            if (right == chars.length - 1) {
                if (left == chars.length - 1) {
                    break;
                }
                left++;
                right = left;
            }

            if (vowels.contains(chars[right])) {
                count++;
                if (count == k) {
                    return count;
                }
                right++;
            } else {
                left = right + 1;
                right = left;
                if (count > res) {
                    res = count;
                }
                count = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("weallloveyou", 7));
    }
}
