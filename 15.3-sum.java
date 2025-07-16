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
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } 
            helper(nums, i);
        }
        return ans;
    }

    public void helper(int[] nums, int index) {
        int rest = 0 - nums[index];
        int left = index + 1;
        int right = nums.length - 1;
        while (left < right) {
            if ((nums[right] + nums[left]) < rest) left += 1;
            else if (nums[left] + nums[right] > rest) right -= 1;
            else {
                List<Integer> current = new ArrayList();
                current.add(nums[index]);
                current.add(nums[left]);
                current.add(nums[right]);
                ans.add(current);
                while (left < right && nums[left] == nums[left + 1]) {
                    left += 1;
                }
                left += 1;
            }
        }
    }
}
// @lc code=end

