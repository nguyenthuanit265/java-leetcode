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
        int len = s.length();
        int window = 0;
        while (left < s.length() && right < s.length()) {
            if (count == k) {
                return k;
            }
//            if (window == k) {
//                if (vowels.contains(chars[left])) {
//                    count--;
//                }
//                left++;
//                right = left;
//            }

            if (vowels.contains(chars[right])) {
                count++;
                right++;
                window++;
                if (count > res) {
                    res = count;
                }
                if (window == k) {
                    if (vowels.contains(chars[left])) {
                        count--;
                    }
                    left++;
                    right = left;
                    window = 0;
                }
            } else {
                if (right < len - 1) {
                    right++;
                    window++;
                    if (window == k) {
                        if (vowels.contains(chars[left])) {
                            count--;
                        }
                        left++;
                        right = left;
                        window = 0;
                    }
                } else {
                    if (vowels.contains(chars[left])) {
                        count--;
                    }
                    left++;
                    right = left;
                    window = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("weallloveyou", 7)); // --> 4
    }
}
