/*
 * @lc app=leetcode id=3155 lang=java
 *
 * [3155] Maximum Number of Upgradable Servers
 */

// @lc code=start
class Solution {
    public long helper(long number, long cost, long sell, long money) {
        long left = 0;
        long right = number;
        while (left <= right) {
            long mid = (left + right) / 2;

            if ((money + sell * mid) == (cost * (number - mid))) {
                return number - mid;
            }

            if ((money + sell * mid) > (cost * (number - mid))) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return number - left;
    }
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int num = count.length;
        int[] ret = new int[num];
        for (int i = 0; i < num; i++) {
            ret[i] = (int)(helper(count[i], upgrade[i], sell[i], money[i]));
        }
        return ret;
    }
}
// @lc code=end

