/*
 * @lc app=leetcode id=2016 lang=java
 *
 * [2016] Maximum Difference Between Increasing Elements
 */

// @lc code=start
class Solution {
    public int maximumDifference(int[] nums) {
        int premin = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (premin < nums[i]) ans = Math.max(ans, nums[i] - premin);
            else premin = nums[i];
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
// @lc code=end

