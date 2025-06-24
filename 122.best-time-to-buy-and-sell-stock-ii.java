/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int high = prices[0];
        int low = prices[0];
        int i = 0;
        int ans = 0;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i+= 1;
            high = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i+= 1;
            low = prices[i];
            ans += high - low;
            i += 1;
        }
        return -ans;
    }
}
// @lc code=end

