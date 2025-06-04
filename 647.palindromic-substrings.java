/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += helper(s, i, i);
            ans += helper(s, i, i + 1);
        }
        return ans;
    }
    public int helper(String s, int low, int high) {
        int ans = 0;
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            low -= 1;
            high += 1;
            ans += 1;
        }
        return ans;
    }
}
// @lc code=end

