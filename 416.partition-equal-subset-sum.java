/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][target + 1];
        return helper(nums, n - 1, target, memo);
    }

    public boolean helper(int[] nums, int index, int sum, Boolean[][] memo) {
        if (sum == 0) {
            return true;
        }
        if (index == 0 || sum < 0) {
            return false;
        }
        if (memo[index][sum] != null) return memo[index][sum];
        boolean result = helper(nums, index - 1, sum, memo) || helper(nums, index - 1, sum - nums[index], memo);
        memo[index][sum] = result;
        return result;
    }
}
// @lc code=end

