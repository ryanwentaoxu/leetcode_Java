/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int curr = 0;
        int p2 = nums.length - 1;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                int tmp = nums[curr];
                nums[curr++] = nums[p0];
                nums[p0++] = tmp;
            } else if (nums[curr] == 2) {
                int tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr += 1;
        }
    }
}
// @lc code=end

