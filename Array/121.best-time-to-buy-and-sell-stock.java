/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int min_till_now = prices[0];
        int profit = 0;
        int temp_profit;

        for (int price : prices) {
            min_till_now = Math.min(price, min_till_now);
            temp_profit = price - min_till_now;
            profit = Math.max(temp_profit, profit);
        }

        return profit;
    }
}
// @lc code=end
