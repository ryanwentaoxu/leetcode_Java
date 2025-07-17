/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        
        int index = 0;
        int sign = 1;
        int ans = 0;
        while (index < s.length() && s.charAt(index) == ' ') index += 1;
        if (index < s.length() && s.charAt(index) == '+') {
            sign = 1;
            index += 1;
        } else if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index += 1;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            if (Integer.MAX_VALUE / 10 < ans || (ans == Integer.MAX_VALUE / 10 && s.charAt(index) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + s.charAt(index) - '0';
            index += 1;
        }
        return sign * ans;
    }
}
// @lc code=end

