package com.learn.grind75.problem1.solution1;

import java.util.*;

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

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // Not found
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
