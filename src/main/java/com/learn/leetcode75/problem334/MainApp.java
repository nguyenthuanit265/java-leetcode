package com.learn.leetcode75.problem334;

import java.util.*;

public class MainApp {
    public boolean increasingTriplet(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    if (map.containsKey(j)) {
                        map.put(i, new ArrayList<>(List.of(j)));
                    } else {
                        List<Integer> val = map.get(j);
                        val.add(j);
                        map.put(i, val);
                    }
                }
            }
        }
        for (List<Integer> values : map.values()) {
            for (int i = 0; i < values.size(); i++) {
                for (int j = i + 1; j < values.size(); j++) {
                    if (values.get(j) > values.get(i)) {
                       return true;
                    }
                }
            }
        }





        return false;
    }

    public static void main(String[] args) {

    }
}
