/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int binarySearch(int[] nums, int left, int right, int target) {
        int start = left;
        int end = right;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            int pivot = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    pivot = mid;
                    break;
                }
                if (nums[mid] < nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (target >= nums[0]) return binarySearch(nums, 0, pivot, target);
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }
}
// @lc code=end

