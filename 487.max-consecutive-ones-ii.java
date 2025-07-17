/*
 * @lc app=leetcode id=487 lang=java
 *
 * [487] Max Consecutive Ones II
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int acc = 1;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                acc -= 1;
            }
            if (acc < 0) {
                acc += nums[left] == 1 ? 0 : 1;
                left += 1;
            }
        }
        return right - left;
    
    }
}
// @lc code=end

