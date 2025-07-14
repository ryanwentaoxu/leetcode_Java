/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int lm = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftMax[i] = lm;
            lm = Math.max(lm, height[i]);
        }
        int rm = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = rm;
            rm = Math.max(rm, height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int upper = Math.min(rightMax[i], leftMax[i]);
            if (upper >= height[i]) ans += upper - height[i];
        }
        return ans;
    }
}
// @lc code=end

