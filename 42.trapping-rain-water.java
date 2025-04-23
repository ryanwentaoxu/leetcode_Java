/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int[] right_max = new int[height.length];
        int[] left_max = new int[height.length];

        right_max[height.length - 1] = Integer.MIN_VALUE;
        left_max[0] = Integer.MIN_VALUE;
        
        int leftMax = height[0];
        int rightMax= height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            left_max[i] = leftMax;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i + 1]);
            right_max[i] = rightMax;
        }
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.max(0, Math.min(right_max[i], left_max[i]) - height[i]);
        }
        return ans;
    }
}
// @lc code=end

