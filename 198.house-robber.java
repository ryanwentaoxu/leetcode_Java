/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int t1 = 0;
        int t2 = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.max(t1 + nums[i], t2);
            t1 = t2;
            t2 = tmp;
        }
        return Math.max(t1, t2);
    }
}
// @lc code=end

