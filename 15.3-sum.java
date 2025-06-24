/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            helper(nums, nums[i], i + 1, ans);
        }
        return ans;
    }

    public void helper(int[] nums, int n, int start, List<List<Integer>> ans) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] + n == 0) {
                List<Integer> tmp = new ArrayList();
                tmp.add(n);
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                ans.add(tmp);
                while (nums[left] == nums[left + 1] & left + 1 < right) {
                    left += 1;
                }
                left += 1;
            } else if (nums[left] + nums[right] + n < 0) {
                left += 1;
            } else {
                right -= 1;
            }
        }
    }
}
// @lc code=end

