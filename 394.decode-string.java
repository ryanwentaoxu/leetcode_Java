/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index))) {
                sb.append(s.charAt(index));
                index += 1;
            } else {
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (int)(s.charAt(index) - '0');
                    index += 1;
                }
                index += 1;
                String next = decodeString(s);
                index += 1;
                for (int tmp = 0; tmp < num; tmp++) sb.append(next);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

