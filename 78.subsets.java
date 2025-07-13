/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    List<List<Integer>> output = new ArrayList ();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        ArrayList<Integer> currCombo = new ArrayList();
        backtrack(0, currCombo, nums);
        return output;
    }
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        output.add(new ArrayList(curr));
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.removeLast();
        }
    }
}
// @lc code=end

