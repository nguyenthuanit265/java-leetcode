package com.learn.leetcode75.problem1431;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> res = new ArrayList<>();
        for (int i = 1; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
