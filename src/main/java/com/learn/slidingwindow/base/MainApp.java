package com.learn.slidingwindow.base;

//Problem: Given an array of integers, find the maximum sum of a subarray with a fixed window size.
public class MainApp {
    public static int maxSubArraySum(int[] nums, int k) {
        int ans;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        ans = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            ans = Math.max(ans, windowSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }
}
