/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int search(List<Integer> list, int target) {
        int right = list.size() - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == target) return mid;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < nums[i])
                list.add(nums[i]);
            else {
                int toInsert = search(list, nums[i]);
                list.set(toInsert, nums[i]);
            }
        }
        return list.size();
    }
}
// @lc code=end

