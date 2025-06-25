/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack();
        Stack<Integer> op = new Stack();
        int sign = 1;
        int num = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (int)(s.charAt(i) - '0');
            } else if (s.charAt(i) == '+') {
                ans += num * sign;
                num = 0;
                sign = 1;
            } else if (s.charAt(i) == '-') {
                ans += num * sign;
                num = 0;
                sign = -1;
            } else if (s.charAt(i) == '(') {
                nums.push(ans);
                op.push(sign);
                ans = 0;
                num = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                ans += num * sign;
                ans = nums.pop() + op.pop() * ans;
                num = 0;
                sign = 1;
            }
        }
        return ans + sign * num;
    }
}
// @lc code=end

