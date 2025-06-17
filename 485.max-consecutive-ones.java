/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int ans = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                i += 1;
            } else {
                int tmp = 1;
                int j = i + 1;
                for (j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 1) {
                        tmp += 1;
                    } else {
                        break;
                    }
                }
                i = j + 1;
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}
// @lc code=end

