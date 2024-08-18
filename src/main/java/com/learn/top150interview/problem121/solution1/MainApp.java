package com.learn.top150interview.problem121.solution1;

//Title: 121. Best Time to Buy and Sell Stock
//Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
public class MainApp {
    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > ans) {
                    ans = prices[j] - prices[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
