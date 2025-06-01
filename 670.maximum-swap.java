/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        int maxIndex = -1;
        char[] nums = String.valueOf(num).toCharArray();
        int swapIndex1 = -1;
        int swapIndex2 = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxIndex == -1 || nums[i] > nums[maxIndex]) maxIndex = i;
            else if (nums[i] < nums[maxIndex]) {
                swapIndex1 = i;
                swapIndex2 = maxIndex;   
            }
        }

        if (swapIndex1 != -1 && swapIndex2 != -1) {
            char tmp = nums[swapIndex1];
            nums[swapIndex1] = nums[swapIndex2];
            nums[swapIndex2] = tmp;
        }
        
        String n = new String(nums);
        return Integer.valueOf(n);
    }
}
// @lc code=end

