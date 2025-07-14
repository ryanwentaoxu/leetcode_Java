/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int maxVal = prices[prices.length - 1];
        int[] minv = new int[prices.length];
        minv[0] = minVal;
        int[] maxv = new int[prices.length];
        maxv[prices.length - 1] = maxVal;
        for (int i = 1; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            minv[i] = minVal;
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            maxVal = Math.max(maxVal, prices[i]);
            maxv[i] = maxVal;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, maxv[i] - minv[i]);
        }
        return ans;
    }
}
// @lc code=end

