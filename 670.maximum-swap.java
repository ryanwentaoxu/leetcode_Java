/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        int swapId1 = -1;
        int swapId2 = -1;
        int maxId = -1;
        char[] nums = String.valueOf(num).toCharArray();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxId == -1 || (int)(nums[i] - '0') > (int)(nums[maxId] - '0')) {
                maxId = i;
            } else if ((int)(nums[i] - '0') < (int)(nums[maxId] - '0')) {
                swapId1 = i;
                swapId2 = maxId;
            }
        }

        if (swapId1 != -1 && swapId2 != -1) {
            char tmp = nums[swapId1];
            nums[swapId1] = nums[swapId2];
            nums[swapId2] = tmp;
        }
        return Integer.parseInt(new String(nums));
    }
}
// @lc code=end

