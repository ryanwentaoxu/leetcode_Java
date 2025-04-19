/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        int n = nums.length - 1;
        for (int i = n; i >= 0; i--) {
            if (nums[i] + i >= lastPos) lastPos = i;
        }
        return lastPos == 0;
    }
}
// @lc code=end

