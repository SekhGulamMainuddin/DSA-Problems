package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            int dif= prices[i] - mini;
            profit = Math.max(dif, profit);
            if(prices[i]<mini){
                mini = prices[i];
            }
        }
        return profit;
    }
}
