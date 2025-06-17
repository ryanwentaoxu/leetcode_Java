/*
 * @lc app=leetcode id=2965 lang=java
 *
 * [2965] Find Missing and Repeated Values
 */

// @lc code=start
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long sum = n * n * (n * n + 1) * (2 * n * n + 1) / 6;
        long sum3 = n * n * (n * n + 1) / 2;
        long sum2 = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum2 += grid[i][j] * grid[i][j];
                sum3 = sum3 - grid[i][j];
            }
        }
        // tmp = y^2 - x^2;
        // sum3 = y - x
        // s = y + x
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum);
        long tmp = sum - sum2;
        System.out.println(tmp);
        long s = tmp / sum3;
        int[] ret = new int[2];
        ret[1] = (int)(s + sum3) / 2;
        ret[0] = (int)(s - sum3) / 2;
        return ret;
    }
}
// @lc code=end

