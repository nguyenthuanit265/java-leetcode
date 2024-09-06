package com.learn.slidingwindow.problem1.solution2;

import java.util.*;

//Title: 1. Two Sum
//Link: https://leetcode.com/problems/two-sum/description/
public class MainApp {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                List<Integer> listIndex = map.get(target - nums[i]);
                for (int itemIndex : listIndex) {
                    if (itemIndex != i) {
                        return new int[]{i, itemIndex};
                    }
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
