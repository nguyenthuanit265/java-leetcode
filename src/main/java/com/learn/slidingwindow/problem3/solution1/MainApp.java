package com.learn.slidingwindow.problem3.solution1;


//Title: 3. Longest Substring Without Repeating Characters
//Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class MainApp {
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder window = new StringBuilder();
        int ans = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (window.indexOf(String.valueOf(s.charAt(right))) < 0) {
                ans = Math.max(ans, right - left + 1);
                window.append(s.charAt(right));
                right++;
            } else {
                window = new StringBuilder();
                left++;
                right = left;
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
