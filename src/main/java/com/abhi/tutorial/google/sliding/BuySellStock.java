package com.abhi.tutorial.google.sliding;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuySellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = left + 1;
        while (right < prices.length && left <= right) {
            if (prices[left] > prices[right]) {
                left = right;
            }
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            right++;
        }
        return maxProfit;
    }
}
