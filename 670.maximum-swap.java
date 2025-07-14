/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        int maxId = -1;
        int swapId1 = -1;
        int swapId2 = -1;
        char[] nums = String.valueOf(num).toCharArray();
        int index = nums.length - 1;
        while (index >= 0) {
            if (maxId == -1 || nums[index] - '0' > nums[maxId] - '0') {
                maxId = index;
            } else if (nums[index] - '0' < nums[maxId] - '0') {
                swapId1 = index;
                swapId2 = maxId;
            }
            index -= 1;
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

