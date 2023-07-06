package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

import java.util.List;
import java.util.ArrayList;

class Solution {

    // Simple Recursive Solution
    // public int solve(int index, int buyOrSell, List<Integer> prices) {
    //     if (index == prices.size())
    //         return 0;

    //     int profit = 0;

    //     if (buyOrSell == 1) {
    //         int buy = -prices.get(index) + solve(index + 1, 0, prices);
    //         int skip = solve(index + 1, 1, prices);
    //         profit = Math.max(buy, skip);
    //     } else {
    //         int sell = prices.get(index) + solve(index + 1, 1, prices);
    //         int skip = solve(index + 1, 0, prices);
    //         profit = Math.max(sell, skip);
    //     }
    //     return profit;
    // }

    // Recursion + Memoization (Top-Down Approach)
    // public int solve(int index, int buyOrSell, List<Integer> prices,
    //         List<List<Integer>> dp) {
    //     if (index == prices.size())
    //         return 0;
    //     if (dp.get(index).get(buyOrSell) != -1)
    //         return dp.get(index).get(buyOrSell);
    //     int profit = 0;

    //     if (buyOrSell == 1) {
    //         int buy = -prices.get(index) + solve(index + 1, 0, prices, dp);
    //         int skip = solve(index + 1, 1, prices, dp);
    //         profit = Math.max(buy, skip);
    //     } else {
    //         int sell = prices.get(index) + solve(index + 1, 1, prices, dp);
    //         int skip = solve(index + 1, 0, prices, dp);
    //         profit = Math.max(sell, skip);
    //     }
    //     dp.get(index).set(buyOrSell, profit);
    //     return dp.get(index).get(buyOrSell);
    // }

    // Tabulation Method (Bottom-Up Approach)
    // public int solve(List<Integer> prices) {
    //     int n = prices.size();
    //     List<List<Integer>> dp = new ArrayList<>(n + 1);
    //     for (int i = 0; i <= n; i++) {
    //         dp.add(new ArrayList<>(2));
    //         dp.get(i).add(0);
    //         dp.get(i).add(0);
    //     }
    //     for (int index = n - 1; index >= 0; index--) {
    //         for (int buyOrSell = 0; buyOrSell <= 1; buyOrSell++) {
    //             int profit = 0;
    //             if (buyOrSell == 1) {
    //                 int buy = -prices.get(index) + dp.get(index + 1).get(0);
    //                 int skip = dp.get(index + 1).get(1);
    //                 profit = Math.max(buy, skip);
    //             } else {
    //                 int sell = prices.get(index) + dp.get(index + 1).get(1);
    //                 int skip = dp.get(index + 1).get(0);
    //                 profit = Math.max(sell, skip);
    //             }
    //             dp.get(index).set(buyOrSell, profit);
    //         }
    //     }
    //     return dp.get(0).get(1);
    // }

    public int solve(List<Integer> prices) {
        int n = prices.size();
        List<Integer> curr = new ArrayList<>(2);
        curr.add(0);
        curr.add(0);
        List<Integer> next = new ArrayList<>(2);
        next.add(0);
        next.add(0);
        for (int index = n - 1; index >= 0; index--) {
            for (int buyOrSell = 0; buyOrSell <= 1; buyOrSell++) {
                int profit = 0;
                if (buyOrSell == 1) {
                    int buy = -prices.get(index) + next.get(0);
                    int skip = next.get(1);
                    profit = Math.max(buy, skip);
                } else {
                    int sell = prices.get(index) + next.get(1);
                    int skip = next.get(0);
                    profit = Math.max(sell, skip);
                }
                curr.set(buyOrSell, profit);
            }
            next = new ArrayList<>(curr);
        }
        return curr.get(1);
    }

    public int maxProfit(List<Integer> prices) {
        // return solve(0, 1, prices);

        // List<List<Integer>> dp = new ArrayList<>();
        // for (int i = 0; i <= prices.size(); i++) {
        //     List<Integer> row = new ArrayList<>();
        //     row.add(-1);
        //     row.add(-1);
        //     dp.add(row);
        // }
        // return solve(0, 1, prices, dp);

        // return solve(prices);
        return solve(prices);
    }
}