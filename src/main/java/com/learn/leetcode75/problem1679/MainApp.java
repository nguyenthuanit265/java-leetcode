package com.learn.leetcode75.problem1679;

import java.util.Arrays;

public class MainApp {
    public static int maxOperations(int[] nums, int k) {
        int left = 0, right = nums.length - 1, res = 0;
        Arrays.sort(nums);
        while (left < right) {
            if (k < nums[left] + nums[right]) {
                right--;
            } else if (k > nums[left] + nums[right]) {
                left++;
            } else {
                left++;
                right--;
                res++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
