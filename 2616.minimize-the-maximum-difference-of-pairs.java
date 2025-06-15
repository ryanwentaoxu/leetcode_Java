/*
 * @lc app=leetcode id=2616 lang=java
 *
 * [2616] Minimize the Maximum Difference of Pairs
 */

// @lc code=start
class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (helper(nums, mid)  >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int helper(int[] nums, int k) {
        int index = 0;
        int count = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] - nums[index] <= k) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
}
// @lc code=end

