/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxLen = 1001;
        int[] nums = new int[maxLen];
        for (int[] trip : trips) {
            nums[trip[1]] += trip[0];
            nums[trip[2]] -= trip[0];
        }
        int ans = 0;
        for (int n : nums) {
            ans += n;
            if (ans > capacity) return false;
        }
        return true;
    }
}
// @lc code=end

