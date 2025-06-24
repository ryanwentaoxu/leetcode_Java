/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> l = new ArrayList();
                l.add(1);
                ans.add(l);
                continue;
            }
            ans.add(helper(ans.get(ans.size() - 1)));
        }
        return ans;
    }

    public List<Integer> helper(List<Integer> prev) {
        int size = prev.size() + 1;
        System.out.println(size);
        List<Integer> current = new ArrayList();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                current.add(1);
            } else if (i == size - 1) {
                current.add(1);
            } else {
                current.add(prev.get(i - 1) + prev.get(i));
            }
        }
        return current;
    }
}
// @lc code=end

