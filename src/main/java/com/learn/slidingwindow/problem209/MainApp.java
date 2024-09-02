package com.learn.slidingwindow.problem209;

//Title: 209. Minimum Size Subarray Sum
//Link: https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MainApp {
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, left = 0, right = 0;
        int curSum = 0;

        while (right < nums.length && left <= right) {
            curSum += nums[right];
            if (curSum < target) {
                right++;
            } else if (curSum >= target) {
                while (curSum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    curSum -= nums[left];
                    left++;
                }

//                if (curSum < target) {
//                    right++;
//                }
                right++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        // Output: 2
        // The subarray [4,3] has the minimal length under the problem constraint.
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

        // Output: 1
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));

        // Output: 0
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

        // Output: 3 - [3,4,5]
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));

        // Output: 5 - [1,2,3,4,5]
        System.out.println(minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
    }
}
