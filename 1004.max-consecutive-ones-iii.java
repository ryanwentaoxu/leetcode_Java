/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int tk = k;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                tk -= 1;
            }
            if (tk < 0) {
                tk += nums[left] == 1 ? 0 : 1;
                left += 1;
            }
        }
        return right - left;
    }
}
// @lc code=end

