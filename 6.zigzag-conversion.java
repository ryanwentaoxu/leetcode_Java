/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        boolean backward = true;
        int index = 0;
        for (char c : s.toCharArray()) {
            rows[index] += String.valueOf(c);
            if (index == 0 || index == numRows - 1) {
                backward = !backward;
            }
            if (backward) {
                index -= 1;
            } else {
                index += 1;
            }
        }
        String ans = "";
        for (String ss : rows) {
            ans += ss;
        }
        return ans;
    }
}
// @lc code=end

