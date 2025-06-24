/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int freq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                freq += 1;
            } else {
                freq -= 1;
                if (freq == 0) {
                    num = nums[i];
                    freq = 1;
                }
            }
        }
        return num;
    }
}
// @lc code=end

