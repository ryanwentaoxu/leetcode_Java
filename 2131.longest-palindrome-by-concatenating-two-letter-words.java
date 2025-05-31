/*
 * @lc app=leetcode id=2131 lang=java
 *
 * [2131] Longest Palindrome by Concatenating Two Letter Words
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String[] words) {
        int R = 26;
        int[][] dp = new int[R][R];
        for (String word : words) {
            dp[(int)(word.charAt(0) - 'a')][(int)(word.charAt(1) - 'a')] += 1;
        }

        int ans = 0;
        boolean central = false;
        for (int i = 0; i < R; i++) {
            int current = dp[i][i];
            
            if (current % 2 == 0) {
                ans += dp[i][i]; 
            } else {
                ans += dp[i][i] - 1;
                central = true;
            }

            for (int j = i + 1; j < R; j++) {
                ans += 2 * Math.min(dp[i][j], dp[j][i]);
            }
        }

        if (central) ans += 1;

        return 2 * ans;
    }
}
// @lc code=end

