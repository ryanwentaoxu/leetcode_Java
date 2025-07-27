/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        dp = new Boolean[nums.length][target + 1];
        return helper(nums, 0, target);
    }

    public boolean helper(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index >= nums.length) return false;
        if (target < 0) return false;
        if (dp[index][target] != null) return dp[index][target];

        boolean result = helper(nums, index + 1, target - nums[index]) || helper(nums, index + 1, target);
        dp[index][target] = result;
        return result;
    }
}
// @lc code=end

