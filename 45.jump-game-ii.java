/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int currentEnd = 0;
        int currentFar = 0;
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            currentFar = Math.max(currentFar, nums[i] + i);
            if (i == currentEnd) {
                ans += 1;
                currentEnd = currentFar;
            }
        }
        return ans;
    }
}
// @lc code=end

