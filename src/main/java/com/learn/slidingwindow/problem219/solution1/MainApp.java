package com.learn.slidingwindow.problem219.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Title: 219. Contains Duplicate II
//Link: https://leetcode.com/problems/contains-duplicate-ii/description/
public class MainApp {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
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

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 2) {
                continue;
            }
            int cur = 0, next = 1;
            while (next < list.size()) {
                if (list.get(next) - list.get(cur) <= k) {
                    return true;
                } else {
                    cur++;
                    next++;
                }
            }
        }

        return false;
    }

//    Input: nums = [1,2,3,1], k = 3
//    Output: true

//    Input: nums = [1,0,1,1], k = 1
//    Output: true

//    Input: nums = [1,2,3,1,2,3], k = 2
//    Output: false

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
