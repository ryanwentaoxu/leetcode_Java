/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int result = 0;
        int operand = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) == true) {
                operand = operand * 10 + (int)(c - '0');
            } else if (c == '+') {
                result += operand * sign;
                operand = 0;
                sign = 1;
            } else if (c == '-') {
                result += operand * sign;
                operand = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                operand = 0;
                sign = 1;
            } else if (c == ')') {
                result += operand * sign;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
                sign = 1;
            }
        }
        return result + operand * sign;
    }
}
// @lc code=end

