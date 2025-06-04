/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public void swap(int[] nums, int index1 ,int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < nums.length) {
            int index = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[index] != nums[i]) {
                swap(nums, i, index);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
// @lc code=end

