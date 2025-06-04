/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] m : memo) {
            Arrays.fill(m, Integer.MIN_VALUE);
        }
        return helper(nums, 0, 0, target, memo);
    }

    public int helper(int[] nums, int index, int sum, int target, int[][] memo) {
        if (index == nums.length) {
            if (target == sum) return 1;
            return 0;
        }  else {
            if (memo[index][sum + totalSum] != Integer.MIN_VALUE) {
                return memo[index][sum + totalSum];
            }
            int add = helper(nums, index + 1, sum + nums[index], target, memo);
            int sub = helper(nums, index + 1, sum - nums[index], target, memo);
            memo[index][sum + totalSum] = add + sub;
            return memo[index][sum + totalSum];
        }
    }
}
// @lc code=end

