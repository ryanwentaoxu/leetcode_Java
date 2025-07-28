/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] fc = new int[k + 1];
        int[] rc = new int[k + 1];

        for (int i = 0; i < k; i++) {
            fc[i + 1] = cardPoints[i] + fc[i];
            rc[i + 1] = cardPoints[n - i - 1] + rc[i]; 
        }

        int ans = 0;
        for (int i = 0; i <= k; i++) {
            int currentScore = fc[i] + rc[k - i];
            ans = Math.max(ans, currentScore);
        }
        return ans;
    }
}
// @lc code=end

