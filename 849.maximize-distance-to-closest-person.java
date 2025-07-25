/*
 * @lc app=leetcode id=849 lang=java
 *
 * [849] Maximize Distance to Closest Person
 */

// @lc code=start
class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int prev = -1;
        int future = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i) {
                    future += 1;
                }
                int left = (prev == - 1 ? N : i - prev);
                int right = (future == N ? N : future - i);
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }
}
// @lc code=end

