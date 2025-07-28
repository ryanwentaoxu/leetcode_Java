/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int helper(int[] nums) {
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.max(t1 + nums[i], t2);
            t1 = t2;
            t2 = tmp;
        }
        return t2;
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }
}
// @lc code=end

