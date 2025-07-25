/*
 * @lc app=leetcode id=1498 lang=java
 *
 * [1498] Number of Subsequences That Satisfy the Given Sum Condition
 */

// @lc code=start
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] power = new int[n + 1];
        power[0] = 1;
        int mod = 1000000000 + 7;
        for (int i = 1; i < n + 1; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int left = 0;
        int right = n - 1;
        int ans = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans += power[(right - left)];
                ans = ans % mod;
                left += 1;
            } else {
                right -= 1;
            }
        }
        return ans;
    }
}
// @lc code=end

