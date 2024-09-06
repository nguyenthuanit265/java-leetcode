package com.learn.grind75.problem53.solution1;

//Title: 53. Maximum Subarray
//Link: https://leetcode.com/problems/maximum-subarray/description/
public class MainApp {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int ans = nums[0], sum = 0;
        int l = 0, r = 0;
        while (l < nums.length) {
            sum += nums[r];
            if (sum > ans) {
                ans = sum;
                if (r == nums.length - 1) {
                    l++;
                    r = l;
                    sum = 0;
                } else {
                    r++;
                }
            } else {
                if (r == nums.length - 1) {
                    l++;
                    r = l;
                    sum = 0;
                } else {
                    r++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // Output: 6. The subarray [4,-1,2,1] has the largest sum 6.
        System.out.println(maxSubArray(new int[]{1})); // Output: 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8})); // Output: 23. The subarray [5,4,-1,7,8] has the largest sum 23.
    }
}
