package com.learn.leetcode75.problem238;

import java.util.Arrays;

public class MainApp {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
            } else {
                left[i] = left[i - 1] * nums[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right[i] = 1;
            } else {
                right[i] = nums[i + 1] * right[i + 1];
            }
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
