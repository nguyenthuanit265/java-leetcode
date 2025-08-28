package com.learn.leetcode75.problem334;

public class MainApp {
    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
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
