/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            helper(nums, i);
        }
        return ans;
    }

    public void helper(int[] nums, int index) {
        int left = index + 1;
        int right = nums.length - 1;
        while (left < right){
            int s = nums[index] + nums[left] + nums[right];
            if (s == 0) {
                List<Integer> tmp = new ArrayList();
                tmp.add(nums[index]);
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                ans.add(tmp);
                while (left < right && nums[left] == nums[left + 1]) {
                    left += 1;
                }
                left += 1;
            } else if (s > 0) {
                right -= 1;
            } else {
                left += 1;
            }
        }
    }
}
// @lc code=end

