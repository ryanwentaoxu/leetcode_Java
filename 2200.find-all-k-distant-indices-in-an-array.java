/*
 * @lc app=leetcode id=2200 lang=java
 *
 * [2200] Find All K-Distant Indices in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList();
        int r = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; i++) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
// @lc code=end

