/*
 * @lc app=leetcode id=2929 lang=java
 *
 * [2929] Distribute Candies Among Children II
 */

// @lc code=start
class Solution {
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            int remain = n - i;
            if (remain > 2 * limit) continue;
            ans += Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1; 
        }
        return ans;
    }
}
// @lc code=end

