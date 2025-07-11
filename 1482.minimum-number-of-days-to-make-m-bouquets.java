/*
 * @lc app=leetcode id=1482 lang=java
 *
 * [1482] Minimum Number of Days to Make m Bouquets
 */

// @lc code=start
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }
        int minDays = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (getNumberOfB(bloomDay, mid, k) >= m) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minDays;
    }

    public int getNumberOfB(int[] bloomDay, int mid, int k) {
        int numOfB = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count += 1;
            } else {
                count = 0;
            }

            if (count == k) {
                numOfB += 1;
                count = 0;
            }
        }
        return numOfB;
    }
}
// @lc code=end

