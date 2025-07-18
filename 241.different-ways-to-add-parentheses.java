/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.length() == 1) {
            List<Integer> list = new ArrayList();
            list.add(Integer.parseInt(expression));
            return list;
        }
        if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            List<Integer> list = new ArrayList();
            list.add(Integer.parseInt(expression));
            return list;
        }
        int n = expression.length();
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                char op = expression.charAt(i);
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, n));
                for (int l : left) {
                    for (int r : right) {
                        if (op == '+') ret.add(l + r);
                        if (op == '-') ret.add(l - r);
                        if (op == '*') ret.add(l * r);
                    }
                }
            }
        }
        return ret;
    }
}
// @lc code=end

