/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    List<List<String>> ans;
    int n;
    StringBuilder t;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList();
        Set<Integer> col = new HashSet();
        Set<Integer> diag = new HashSet();
        Set<Integer> antiDiag = new HashSet();
        this.n = n;
        t = new StringBuilder();
        for (int i = 0; i < n; i++) {
            t.append(".");
        }
        List<String> tmp = new ArrayList();
        helper(0, col, diag, antiDiag, tmp);
        return ans;
    }

    public void helper(int row, Set<Integer> col, Set<Integer> diag, Set<Integer> antiDiag, List<String> tmp) {
        if (row == n) {
            ans.add(new ArrayList(tmp));
        }
        for (int i = 0; i < n; i++) {
            int current = i;
            int dia = current + row;
            int anti = current - row;
            if (col.contains(current) || diag.contains(dia) || antiDiag.contains(anti)) {
                continue;
            }
            t.setCharAt(i, 'Q');
            tmp.add(t.toString());
            t.setCharAt(i, '.');
            col.add(i);
            diag.add(dia);
            antiDiag.add(anti);
            helper(row + 1, col, diag, antiDiag, tmp);
            tmp.remove(tmp.size() - 1);
            col.remove(i);
            diag.remove(dia);
            antiDiag.remove(anti);
        }
    }
}
// @lc code=end

