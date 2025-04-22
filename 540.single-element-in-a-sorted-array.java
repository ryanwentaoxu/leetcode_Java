/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // edge case
            if (mid == 0 && nums[0] != nums[1]) {
                return nums[0];
            }
            if (mid == 0 && nums[0] == nums[1]) {
                left = mid + 1;
                continue;
            }

            if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            if (mid == nums.length - 1 && nums[mid] == nums[mid - 1]) {
                right = mid - 1;
                continue;
            }

            // normal case
            
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            int left_count = -1;
            int right_count = -1;
            if (nums[mid] == nums[mid + 1]) {
                left_count = mid;
                right_count = nums.length - 1 - mid;
            }
            
            if (nums[mid] == nums[mid - 1]) {
                left_count = mid - 1;
                right_count = nums.length - mid;
            }

            if (left_count % 2 == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
// @lc code=end

