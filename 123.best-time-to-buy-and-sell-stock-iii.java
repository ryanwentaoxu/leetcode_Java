/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit1 = 0;
        int ans = 0;
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(prices[i] - buy1, profit1);
            buy2 = Math.min(buy2, prices[i] - profit1);
            ans = Math.max(ans, prices[i] - buy2);
        }
        return ans;
    }
}
// @lc code=end

