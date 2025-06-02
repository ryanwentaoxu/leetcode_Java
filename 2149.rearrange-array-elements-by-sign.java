/*
 * @lc app=leetcode id=2149 lang=java
 *
 * [2149] Rearrange Array Elements by Sign
 */

// @lc code=start
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int oddIndex = 0;
        int evenIndex = 1;
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret[oddIndex] = nums[i];
                oddIndex += 2;
            } else {
                ret[evenIndex] = nums[i];
                evenIndex += 2;
            }
        }
        return ret;
    }
}
// @lc code=end

