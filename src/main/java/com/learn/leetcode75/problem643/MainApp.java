package com.learn.leetcode75.problem643;

public class MainApp {
    public static double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        double res = 0, temp = 0, sum = 0;
        while (right < nums.length) {
            int count = 1;
            while (count <= k && right < nums.length) {
                sum += nums[right++];
                count++;
            }

            if (count < k) {
                break;
            }

            temp = sum / k;
            if (res < temp) {
                res = temp;
            }

            sum = 0;
            left++;
            right = left;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
