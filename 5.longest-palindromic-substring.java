/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        boolean [][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;
        for (int i = 0; i < s.length() - 1; i++) {
            helper(s, i, dp);    
        }
        String ans = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (dp[i][j]) {
                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    public void helper(String s, int index, boolean[][] dp) {
        if (s.charAt(index) == s.charAt(index + 1)) {
            dp[index][index + 1] = true;
            int left = index - 1;
            int right = index + 2;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = true;
                    left -= 1;
                    right += 1;
                } else {
                    break;
                }
            }
        }
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                dp[left][right] = true;
                left -= 1;
                right += 1;
            } else {
                break;
            }
        }
    }
}
// @lc code=end

