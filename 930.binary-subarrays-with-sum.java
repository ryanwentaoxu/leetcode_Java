/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
    public int helper(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        for (right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > k && left < right) {
                sum -= nums[left];
                left += 1;
            }
            if (sum <= k) ans += right - left + 1;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }
}
// @lc code=end

