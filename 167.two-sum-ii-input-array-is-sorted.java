/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] ret = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ret[0] = left + 1;
                ret[1] = right + 1;
                return ret;
            } else if (numbers[left] + numbers[right] < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return ret;
    }
}
// @lc code=end

