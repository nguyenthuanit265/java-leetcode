package com.learn.twopointers.problem16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//Title: 16. 3Sum Closest
//Link: https://leetcode.com/problems/3sum-closest/description/
public class MainApp {
    public static int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int[] ansOpt = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    if (Math.abs(target - (nums[i] + nums[l] + nums[r])) <= Math.abs(target - ans)) {
                        ans = nums[i] + nums[l] + nums[r];
                        ansOpt[index++] = ans;
                    }
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > target) {
                    if (Math.abs(target - (nums[i] + nums[l] + nums[r])) <= Math.abs(target - ans)) {
                        ans = nums[i] + nums[l] + nums[r];
                        ansOpt[index++] = ans;
                    }
                    r--;
                } else {
                    return nums[i] + nums[l] + nums[r];
                }
            }
        }

        Arrays.sort(ansOpt);
        for (int i = ansOpt.length - 1; i >= 0; i--) {
            if (ansOpt[i] > 0) {
                ans = ansOpt[i];
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, 100));
    }
}
