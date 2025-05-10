/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> operand = new Stack();
        Stack<Integer> num = new Stack();
        int n = 0;
        int ans = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                n = n * 10 + (int)(s.charAt(i) - '0');
            } else if (s.charAt(i) == '+') {
                ans += n * sign;
                n = 0;
                sign = 1;
            } else if (s.charAt(i) == '-') {
                ans += n * sign;
                n = 0;
                sign = -1;
            } else if (s.charAt(i) == '(') {
                num.push(ans);
                operand.push(sign);
                ans = 0;
                n = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                ans += sign * n;
                ans = num.pop() + operand.pop() * ans;
                n = 0;
                sign = 1;
            }
        }

        return ans + n * sign;
    }
}
// @lc code=end

