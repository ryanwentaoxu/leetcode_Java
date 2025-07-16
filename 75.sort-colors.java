/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int current = 0;
        while (current <= p2) {
            if (nums[current] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[current];
                nums[current] = tmp;
                p0 += 1;
                current += 1;
            } else if (nums[current] == 2) {
                int tmp = nums[p2];
                nums[p2] = nums[current];
                nums[current] = tmp;
                p2 -= 1;
            } else {
                current += 1;
            }
        }
    }
}
// @lc code=end

