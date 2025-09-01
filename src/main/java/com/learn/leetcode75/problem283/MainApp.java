package com.learn.leetcode75.problem283;

import java.util.Arrays;

public class MainApp {
    public static void moveZeroes(int[] nums) {
        int read = 0, write = 0;
        int n = nums.length;
        while (read < n) {
            if (nums[read] != 0) {
                nums[write++] = nums[read];
            }
            read++;
        }

        while (write < n) {
            nums[write++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});

    }
}
