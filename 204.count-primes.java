/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        return helper(n);
    }

    public int helper(int n) {
        boolean[] nums = new boolean[n + 1];
        Arrays.fill(nums, false);
        for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
            if (nums[i] == false) {
                int start = i * i;
                for (int j = start; j <= n; j += i) {
                    nums[j] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) ans += 1;
        }
        return ans;
    }
}
// @lc code=end

