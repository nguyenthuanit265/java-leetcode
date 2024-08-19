package com.learn.twopointers.problem125;

import java.util.Objects;

//Title: 125. Valid Palindrome
//Link: https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
public class MainApp {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        System.out.println(s);
        String[] arr = s.split("");
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            if (!Objects.equals(arr[l++], arr[r--])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}
