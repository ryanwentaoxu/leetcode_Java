/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target);
    }

    public List<List<Integer>> helper(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> tmp = new ArrayList();
                tmp.add(candidates[i]);
                ans.add(tmp);
                break;
            } else if (candidates[i] > target) {
                break;
            } else {
                int[] subarray = Arrays.copyOfRange(candidates, i, candidates.length); 
                List<List<Integer>> sub = helper(subarray, target - candidates[i]);
                if (sub.size() == 0) continue;
                for (List<Integer> s : sub) {
                    List<Integer> current = new ArrayList();
                    current.add(candidates[i]);
                    current.addAll(s);
                    ans.add(current); 
                }
            }
        }
        return ans;
    }
}
// @lc code=end

