/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int[] products = new int[nums.length];
        int maxPro = nums[0];
        int minPro = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tmp_max = maxPro;
            maxPro = Math.max(current, Math.max(current * maxPro, current * minPro));
            minPro = Math.min(current, Math.min(current * tmp_max, current * minPro));
            ans = Math.max(maxPro, ans);
        }
        return ans;
    }
}
// @lc code=end

