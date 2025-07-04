/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int index = nums[i];
            if (index >= 0 && index < nums.length && nums[index] != nums[i]) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            } else {
                i = i + 1;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
}
// @lc code=end

