/*
 * @lc app=leetcode id=2303 lang=java
 *
 * [2303] Calculate Amount Paid in Taxes
 */

// @lc code=start
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        List<int[]> l = new ArrayList();
        for (int[] b : brackets) {
            l.add(b);
        }
        l.add(0, new int[]{0, 0});
        double ans = 0;
        for (int i = 1; i < l.size(); i++) {
            if (income >= l.get(i)[0]) {
                ans += (l.get(i)[0] - l.get(i - 1)[0]) * l.get(i)[1] / 100.0;
            } else {
                ans += (income - l.get(i - 1)[0]) * l.get(i)[1] / 100.0;
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

