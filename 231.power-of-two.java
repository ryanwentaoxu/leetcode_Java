/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == Integer.MIN_VALUE) return false;
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') count += 1;
        }
        return count == 1 ? true : false;
    }
}
// @lc code=end

