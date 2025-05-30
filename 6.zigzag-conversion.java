/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int index = 0;
        boolean backward = false;
        String[] ret = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            ret[i] = "";
        }

        for (int i = 0; i < s.length(); i++) {
            ret[index] += String.valueOf(s.charAt(i));
            if (!backward) {
                index += 1;
            } else {
                index -= 1;
            }
            if (index == numRows - 1 || index == 0) {
                backward = !backward;
            }
        }

        String ans = "";
        for (String r : ret) ans += r;
        return ans;
    }
}
// @lc code=end

