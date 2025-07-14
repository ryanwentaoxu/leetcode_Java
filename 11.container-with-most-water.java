/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int range = right - left;
            int current = range * Math.min(height[left], height[right]);
            ans = Math.max(current, ans);
            if (height[left] >= height[right]) right -= 1;
            else left += 1;
        }
        return ans;
    }
}
// @lc code=end

