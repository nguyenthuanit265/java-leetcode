package com.learn.leetcode75.problem334;

import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public boolean increasingTriplet(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(set);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            for (int j = i + 1; j < set.size(); j++) {
                if (nums[i] < nums[j]) {
                    list.add(List.of(i, j));
                }
            }
        }

        if (list.isEmpty()) {
            return false;
        }

        List<Integer> listNums = new ArrayList<>(set);
        for (List<Integer> group : list) {
            int j = group.get(1);
            for (int k = j + 1; k < set.size(); k++) {
                if (listNums.get(k) > listNums.get(j)) {
                    return true;
                }
            }
        }



        return false;
    }

    public static void main(String[] args) {

    }
}
