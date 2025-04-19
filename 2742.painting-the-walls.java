/*
 * @lc app=leetcode id=2742 lang=java
 *
 * [2742] Painting the Walls
 */

// @lc code=start
class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];
        dp[n][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[n][i] = (int)1e9;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int remain = 0; remain <= n; remain++) {
                int paint = cost[i] + dp[i + 1][Math.max(0, remain - time[i] - 1)];
                int dontPaint = dp[i + 1][remain];
                dp[i][remain] = Math.min(paint, dontPaint);
            }
        }
        return dp[0][n];
    }
}
// @lc code=end

