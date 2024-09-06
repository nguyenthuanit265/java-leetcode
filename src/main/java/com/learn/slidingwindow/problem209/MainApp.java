package com.learn.slidingwindow.problem209;

import java.util.Arrays;

//Title: 209. Minimum Size Subarray Sum
//Link: https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MainApp {
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int ans = nums.length;

//        int l = 0, r = nums.length - 1;
//        int sum = 0;
//        while (l < r) {
//            sum += nums[l] + nums[r];
//            if (sum < target) {
//                l++;
//                if (ans < )
//            }
//        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // Output: 2
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4})); // Output: 1
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // Output: 0
    }
}
