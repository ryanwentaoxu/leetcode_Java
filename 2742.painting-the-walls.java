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

        for (int i = 0; i < n + 1; i++) dp[i][0] = 0;
        for (int i = 1; i < n + 1; i++) dp[n][i] = 1000000000;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {

                int remain = Math.max(0, j - (time[i] + 1));
                int paint = cost[i] + dp[i + 1][remain];
                int dontPaint = dp[i + 1][j];
                dp[i][j] = Math.min(paint, dontPaint);

            }
        }
        return dp[0][n];
    }
}
// @lc code=end

