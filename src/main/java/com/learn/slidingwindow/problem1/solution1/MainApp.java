package com.learn.slidingwindow.problem1.solution1;

import java.util.Arrays;

//Title: 1. Two Sum
//Link: https://leetcode.com/problems/two-sum/description/
public class MainApp {
    public static int[] twoSum(int[] nums, int target) {
        int l = 0, r = 1;
        while (l < nums.length) {
            if (nums[l] + nums[r] == target) {
                return new int[]{l, r};
            } else {
                if (r == nums.length - 1) {
                    l++;
                    r = l + 1;
                } else {
                    r++;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
