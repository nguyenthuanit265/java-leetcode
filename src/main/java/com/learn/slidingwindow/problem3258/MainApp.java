package com.learn.slidingwindow.problem3258;

//Title: 3258. Count Substrings That Satisfy K-Constraint I
//Link: https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/
public class MainApp {
    //    Số lượng ký tự '0' trong chuỗi không vượt quá k
    //    Số lượng ký tự '1' trong chuỗi không vượt quá k
    public static int countKConstraintSubstrings(String s, int k) {
        if (k <= 0) {
            return 0;
        }

        int left = 0, right = 0, ans = 0, count0 = 0, count1 = 0;
        while (right < s.length()) {
            if (s.charAt(right) == '0') {
                count0++;
            } else if (s.charAt(right) == '1') {
                count1++;
            }

            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else if (s.charAt(left) == '1') {
                    count1--;
                }
                left++;
            }

            ans += right - left + 1;
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countKConstraintSubstrings("10101", 1)); //12
        System.out.println(countKConstraintSubstrings("1010101", 2)); //25
        System.out.println(countKConstraintSubstrings("11111", 2)); //15
    }
}
