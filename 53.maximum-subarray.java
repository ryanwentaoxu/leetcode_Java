/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, maxSum[i]);
        }
        return ans;
    }
}
// @lc code=end

