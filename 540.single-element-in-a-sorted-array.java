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
            if (mid == 0) {
                if (nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                } else {
                    left = mid + 2;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                } else {
                    right = mid - 2;
                }
            } else {
                if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                } else {
                    if (nums[mid] == nums[mid + 1]) {
                        if (mid % 2 == 0) {
                            left = mid + 2;
                        } else {
                            right = mid - 1;
                        }
                    } else {
                        if ((mid - 1) % 2 == 0) {
                            left = mid + 1;
                        } else {
                            right = mid - 2;
                        }
                    }
                }
            }
        }
        return nums[left];
    }
}
// @lc code=end

