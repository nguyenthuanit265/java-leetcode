package com.learn.recursion.problem231;

//Title: 231. Power of Two
//Link: https://leetcode.com/problems/power-of-two/description/?envType=problem-list-v2&envId=recursion&difficulty=EASY
public class MainApp {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n %2 != 0 && n > 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 0) {
            if (n % 2 != 0 && n > 1) {
                return false;
            }
            n = n/2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(134217727));
    }
}
