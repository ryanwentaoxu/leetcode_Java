/*
 * @lc app=leetcode id=2291 lang=java
 *
 * [2291] Maximum Profit From Trading Stocks
 */

// @lc code=start
class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        List<Pair<Integer, Integer>> pf = new ArrayList();
        for (int i = 0; i < present.length; i++) {
            pf.add(new Pair(present[i], future[i] - present[i]));
        }
        int[][] dp = new int[pf.size() + 1][budget + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (pf.get(i - 1).getKey() <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pf.get(i - 1).getKey()] + pf.get(i - 1).getValue());
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        } 
        return dp[present.length][budget];  
    }
}
// @lc code=end

