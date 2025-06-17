/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[end] = nums[i];
                end += 1;
            }
        }
        for (int i = end; i < nums.length; i++) nums[i] = 0;
    }
}
// @lc code=end

