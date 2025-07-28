/*
 * @lc app=leetcode id=1695 lang=java
 *
 * [1695] Maximum Erasure Value
 */

// @lc code=start
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int score = 0;
        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        while (right <= n && left <= right) {
            if (right < n && map.getOrDefault(nums[right], 0) == 0) {
                int num = nums[right];
                map.put(num, map.getOrDefault(num, 0) + 1);
                score += num;
                ans = Math.max(ans, score);
                right += 1;
            } else {
                if (left == n) break;
                int num = nums[left];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) map.remove(num);
                score -= num;
                left += 1;
            }
        }
        return ans;
    }
}
// @lc code=end

