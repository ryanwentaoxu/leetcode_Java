/*
 * @lc app=leetcode id=3177 lang=java
 *
 * [3177] Find the Maximum Length of a Good Subsequence II
 *
 * https://leetcode.com/problems/find-the-maximum-length-of-a-good-subsequence-ii/description/
 *
 * algorithms
 * Hard (23.80%)
 * Likes:    125
 * Dislikes: 8
 * Total Accepted:    8.1K
 * Total Submissions: 33.9K
 * Testcase Example:  '[1,2,1,1,3]\n2'
 *
 * You are given an integer array nums and a non-negative integer k. A sequence
 * of integers seq is called good if there are at most k indices i in the range
 * [0, seq.length - 2] such that seq[i] != seq[i + 1].
 * 
 * Return the maximum possible length of a good subsequence of nums.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,1,1,3], k = 2
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * The maximum length subsequence is [1,2,1,1,3].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4,5,1], k = 0
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * The maximum length subsequence is [1,2,3,4,5,1].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5 * 10^3
 * 1 <= nums[i] <= 10^9
 * 0 <= k <= min(50, nums.length)
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maximumLength(int[] nums, int k) {
        int[] ans = new int[k + 1];
        Map<Integer, Integer>[] map = new HashMap[k + 1];
        for (int i = 0; i <= k; i++) map[i] = new HashMap();
        for (int n : nums) {
            for (int i = k; i >= 0; i--) {
                int value = map[i].getOrDefault(n, 0);
                value = Math.max(value + 1, i > 0 ? ans[i - 1] + 1 : 0);
                map[i].put(n, value);
                ans[i] = Math.max(ans[i], value);
            }
        }
        return ans[k];
    }
}
// @lc code=end

