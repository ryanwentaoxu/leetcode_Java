/*
 * @lc app=leetcode id=2966 lang=java
 *
 * [2966] Divide Array Into Arrays With Max Difference
 */

// @lc code=start
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ret = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i = i + 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[][]{};
            }
            ret[i / 3] = new int[] {nums[i], nums[i + 1], nums[i + 2]};
        }
        return ret;
    }
}
// @lc code=end

