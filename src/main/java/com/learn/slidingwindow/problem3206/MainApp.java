package com.learn.slidingwindow.problem3206;

//Title: 3206. Alternating Groups I
//Link: https://leetcode.com/problems/alternating-groups-i/description/
public class MainApp {
    public static int numberOfAlternatingGroups(int[] colors) {
        if (colors.length < 3) return 0;
        int ans = 0, l = 0, r = 2;
        while (r < colors.length) {
            if (colors[l] == colors[r] && colors[l + 1] != colors[r]) {
                ans++;
            }

            l++;
            r++;
        }

        if (colors[colors.length - 1] != colors[0]
                && colors[1] == colors[colors.length - 1]) {
            ans++;
        }

        if (colors[colors.length - 1] != colors[0]
                && colors[colors.length - 2] == colors[0]) {
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{1, 1, 1})); // 0
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1})); // 3
    }
}
