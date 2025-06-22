/*
 * @lc app=leetcode id=1752 lang=java
 *
 * [1752] Check if Array Is Sorted and Rotated
 */

// @lc code=start
class Solution {
    public boolean check(int[] nums) {
        int pivot = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) return true;
        for (int i = pivot + 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[0]) return false;
            if (nums[i + 1] > nums[0]) return false;
            
            if (nums[i] > nums[i + 1]) return false;
            
        }
        if (nums[pivot + 1] > nums[0]) return false;
        return true;
    }
}
// @lc code=end

