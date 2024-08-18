package com.learn.twopointers.problem344;

import java.util.Arrays;

//Title: 344. Reverse String
//Link: https://leetcode.com/problems/reverse-string/description/
public class MainApp {
    public static void reverseString(char[] s) {
        class Solution {
            public void reverseString(char[] s) {
                if (s.length == 0) {
                    return;
                }
                int begin = 0;
                int end = s.length - 1;
                int size = s.length - 1;
                for (begin = 0; begin < end; ) {
                    char temp = s[begin];
                    s[begin++] = s[end];
                    s[end--] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        char[] s = new char[]{'1', '2', '3', '4', '5'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
