/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) continue;
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k += 1;
                }
                ans += k - j - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

