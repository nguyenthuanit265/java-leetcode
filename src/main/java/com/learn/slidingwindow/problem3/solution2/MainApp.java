package com.learn.slidingwindow.problem3.solution2;

import java.util.HashMap;
import java.util.Map;

//Title: 3. Longest Substring Without Repeating Characters
//Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class MainApp {
    public static int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int l = 0, r = 0, ans = 0, windowSize = 0;

        while (r < s.length()) {
            if (map.containsKey(String.valueOf(s.charAt(r)))) {
                l = r;
                if (windowSize > ans) {
                    ans = windowSize;
                }
                windowSize = 0;
                map.clear();

            } else {
                windowSize++;
                map.put(String.valueOf(s.charAt(r)), r);
                r++;
            }
        }

        return ans;
    }

    /*
    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    */

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("abcbbcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("abccccbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // Output: 3
        System.out.println(lengthOfLongestSubstring("dvdf")); // Output: 3
    }
}
