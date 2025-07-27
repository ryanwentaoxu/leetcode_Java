/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int n = coins.length;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = 0; j <= amount; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                if (j + coin > amount || j + coin <= 0) continue;
                dp[j + coin] = Math.min(dp[j] + 1, dp[j + coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
// @lc code=end

