package com.learn.top150interview.problem80;

import java.util.*;

//Title: 80. Remove Duplicates from Sorted Array II
//Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class MainApp {
    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> listNums = new ArrayList<>();
        int ans = 0;
        int size = nums.length;
        for (int e : nums) {
            listNums.add(e);
            if (map.containsKey(e)) {
                map.put(e, map.get(e).intValue() + 1);
            } else {
                map.put(e, 1);
            }
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                for (int i = 1; i <= entry.getValue() - 2; i++) {
                    listNums.remove(entry.getKey());
                    ans += 1;
                }
            }
        }

        for (int i = 0; i < listNums.size(); i++) {
            nums[i] = listNums.get(i);
        }

        for (int i = 1, j = 0; i <= ans; i++) {
            nums[(size - 1) - j] = 0;
            j++;
        }

        return (size - ans);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
