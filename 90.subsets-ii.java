/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList();
        List<Integer> ss = new ArrayList();
        helper(nums, 0, ss);
        return ans;
    }

    public void helper(int[] nums, int index, List<Integer> ss) {
        ans.add(new ArrayList(ss));
        int n = nums.length;
        for (int i = index; i < n; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            ss.add(nums[i]);
            helper(nums, i + 1, ss);
            ss.remove(ss.size() - 1);
        }
    }
}
// @lc code=end

