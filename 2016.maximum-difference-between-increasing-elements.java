/*
 * @lc app=leetcode id=2016 lang=java
 *
 * [2016] Maximum Difference Between Increasing Elements
 */

// @lc code=start
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int premin = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > premin) {
                ans = Math.max(ans, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end

