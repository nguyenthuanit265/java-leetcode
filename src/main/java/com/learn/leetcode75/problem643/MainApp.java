package com.learn.leetcode75.problem643;

public class MainApp {
    public static double findMaxAverage(int[] nums, int k) {
        double res = -Double.MAX_VALUE, sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (right - left + 1 == k) {
                double avg = sum / k;
                res = Math.max(res, avg);
                sum -= nums[left++];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
