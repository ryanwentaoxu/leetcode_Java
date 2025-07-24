/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int m = left;
        int n = right;
        int shift = 0;
        // 7 -> 111
        // 5 -> 101
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            shift += 1;
        }
        return m << shift;
    }
}
// @lc code=end

