/*
 * @lc app=leetcode id=1717 lang=java
 *
 * [1717] Maximum Score From Removing Substrings
 */

// @lc code=start
class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0;
        int bCount = 0;
        int totalPoints = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'a') {
                aCount += 1;
            } else if (current == 'b') {
                if (aCount > 0) {
                    aCount -= 1;
                    totalPoints += x;
                } else {
                    bCount += 1;
                }
            } else {
                totalPoints += Math.min(aCount, bCount) * y;
                aCount = 0;
                bCount = 0;
            }
        }
        totalPoints += Math.min(aCount, bCount) * y;
        return totalPoints;
    }
}
// @lc code=end

