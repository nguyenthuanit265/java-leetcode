package com.learn.top150interview.problem169;

import java.util.HashMap;
import java.util.Map;

//Title: 169. Majority Element
//Link: https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
public class MainApp {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = nums[0];
        for (int e : nums) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        int temp = map.get(nums[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2) && entry.getValue() > temp) {
                ans = entry.getKey();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
