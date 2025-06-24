/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            } else {
                int index = bs(sub, nums[i]);
                sub.set(index, nums[i]);
            }
        }
        return sub.size();
    }

    public int bs(List<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sub.get(mid) == num) return mid;
            if (sub.get(mid) < num) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
// @lc code=end

