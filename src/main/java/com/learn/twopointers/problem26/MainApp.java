package com.learn.twopointers.problem26;

import java.util.Arrays;

//Title: 26. Remove Duplicates from Sorted Array
//Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class MainApp {
    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
