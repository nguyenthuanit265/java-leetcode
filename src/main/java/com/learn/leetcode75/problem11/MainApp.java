package com.learn.leetcode75.problem11;

public class MainApp {
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0, right;
        while (left < height.length) {
            right = left + 1;
            while (right < height.length) {
                int d = right - left;
                int r = Math.min(height[left], height[right]);
                if (d * r > max) {
                    max = d * r;
                }
                right++;
            }

            left++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
