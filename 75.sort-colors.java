/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int pZero = 0;
        int pTwo = nums.length - 1;
        int current = 0;
        int n = nums.length;
        while (current <= pTwo) {
            if (nums[current] == 0) {
                int tmp = nums[current];
                nums[current] = nums[pZero];
                nums[pZero] = tmp;
                pZero += 1;
                current += 1;
            } else if (nums[current] == 2) {
                int tmp = nums[current];
                nums[current] = nums[pTwo];
                nums[pTwo] = tmp;
                pTwo -= 1;
            } else {
                current += 1;
            }
        }
    }
}
// @lc code=end

