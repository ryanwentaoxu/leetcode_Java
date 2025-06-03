/*
 * @lc app=leetcode id=777 lang=java
 *
 * [777] Swap Adjacent in LR String
 */

// @lc code=start
class Solution {
    public boolean canTransform(String start, String result) {
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'X') count += 1;
            if (result.charAt(i) == 'X') count -= 1;
        }
        if (count != 0) return false;
        int i = 0;
        int j = 0;
        while (i < start.length() && j < result.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < result.length() && result.charAt(j) == 'X') {
                j++;
            }
            if (i == start.length() || j == result.length()) return i == j;
            if (start.charAt(i) != result.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}
// @lc code=end

