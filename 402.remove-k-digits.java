/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (34.65%)
 * Likes:    9919
 * Dislikes: 522
 * Total Accepted:    583.4K
 * Total Submissions: 1.7M
 * Testcase Example:  '"1432219"\n3'
 *
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= num.length <= 10^5
 * num consists of only digits.
 * num does not have any leading zeros except for the zero itself.
 * 
 * 
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        int count = k;
        for (int i = 0; i < num.length(); i++) {
            while (stack.isEmpty() == false && stack.peek() > num.charAt(i) && count > 0) {
                stack.pop();
                count -= 1;
            }
            stack.push(num.charAt(i));
        }
        while (count > 0) {
            stack.pop();
            count -= 1;
        }
        boolean leadingZero = true;        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            if (leadingZero == true && stack.elementAt(i) == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(stack.elementAt(i));
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
// @lc code=end

