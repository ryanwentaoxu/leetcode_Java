/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            } else {
                dp[0][i] = false;
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                        boolean res1 = dp[i][j - 1];
                        boolean res2 = dp[i][j - 2];
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            boolean res3 = dp[i - 1][j];
                            dp[i][j] = res1 || res2 || res3;
                        } else {
                            dp[i][j] = res1 || res2;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
// @lc code=end

