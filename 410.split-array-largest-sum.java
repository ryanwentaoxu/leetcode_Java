/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int helper(int[] nums, int maxSumAllowed) {
        int currentSum = 0;
        int splitRequired = 0;
        for (int element : nums) {
            if (currentSum + element <= maxSumAllowed) {
                currentSum += element;
            } else {
                currentSum = element;
                splitRequired++;
            }
        }
        return splitRequired + 1;
    }
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int element : nums) {
            sum += element;
            maxElement = Math.max(maxElement, element);
        }

        int left = maxElement;
        int right = sum;
        int minimumLargestSplitSum = 0;
        while (left <= right) {
            int maxSumAllowed = left + (right - left) / 2;
            if (helper(nums, maxSumAllowed) <= k) {
                right = maxSumAllowed - 1;
                minimumLargestSplitSum = maxSumAllowed;
            } else {
                left = maxSumAllowed +1;
            }
        }
        return minimumLargestSplitSum;
    }
}
// @lc code=end

