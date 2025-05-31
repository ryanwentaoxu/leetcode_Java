/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] tmp : dp) {
            Arrays.fill(tmp, -1);
        }
        return helper(word1, word2, word1.length(), word2.length(), dp);
    }

    public int helper(String word1, String word2, int len1, int len2, int[][] dp) {
        if (dp[len1][len2] != -1) return dp[len1][len2];
        if (len1 == 0) {
            dp[len1][len2] = len2;
            return len2;
        }
        if (len2 == 0) {
            dp[len1][len2] = len1;
            return len1;
        }

        if (word1.charAt(len1 - 1) == word2.charAt(len2 - 1)) {
            dp[len1][len2] = helper(word1, word2, len1 - 1, len2 - 1, dp);
            return dp[len1][len2];
        }

        int n1 = helper(word1, word2, len1 - 1, len2, dp) + 1;
        int n2 = helper(word1, word2, len1, len2 - 1, dp) + 1;
        int n3 = helper(word1, word2, len1 - 1, len2 - 1, dp) + 1;
        int ans = Math.min(Math.min(n1, n2), n3);
        dp[len1][len2] = ans;
        return ans;
    }
}
// @lc code=end

