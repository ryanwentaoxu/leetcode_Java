/*
 * @lc app=leetcode id=306 lang=java
 *
 * [306] Additive Number
 */

// @lc code=start
import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (isValid(num, i, j)) return true;
            }
        }
        return false;
    }

    public boolean isValid(String num, int i, int j) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        String sum;
        for (int start = i + j; start < num.length(); start += sum.length()) {
            x2 = x2.add(x1);
            sum = x2.toString();
            x1 = x2.subtract(x1);
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}
// @lc code=end

