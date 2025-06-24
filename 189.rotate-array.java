/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int rk = k % nums.length;
        int[] left = Arrays.copyOfRange(nums, 0, nums.length - rk);
        int[] right = Arrays.copyOfRange(nums, nums.length - rk, nums.length);
        for (int i = 0; i < rk; i++) {
            nums[i] = right[i];
        }
        for (int i = rk; i < nums.length; i++) {
            nums[i] = left[i - rk];
        }
    }
}
// @lc code=end

