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


    public static int maxArea2(int[] height) {
        int max = Integer.MIN_VALUE;
        int n = height.length;
        int left = 0, right = n - 1;

        if (height.length == 0 || height.length == 1) {
            return 0;
        }

        max = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, width * minHeight);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
