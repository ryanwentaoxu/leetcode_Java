/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c : citations) {
            papers[Math.min(n, c)]++;
        }
        int k = n;
        int sum = papers[n];
        while (k > sum) {
            k -= 1;
            sum += papers[k];
        }
        return k;
    }
}
// @lc code=end

