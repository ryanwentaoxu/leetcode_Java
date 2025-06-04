/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        int large = i;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i -= 1;
            large = i;
        }
        int j = nums.length - 1;
        if (large >= 0) {
            while (nums[j] <= nums[i]) {
                j -= 1;
            }
            swap(nums, large, j);
        }
        reverse(nums, large + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
    }
}
// @lc code=end

