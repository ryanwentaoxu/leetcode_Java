/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    int row;
    int col;
    int[][] matrix;
    public int getValue(int len) {
        int crow = len / col;
        int ccol = len % col;
        return matrix[crow][ccol];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        row = matrix.length;
        col = matrix[0].length;
        this.matrix = matrix;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getValue(mid) == target) return true;
            if (getValue(mid) > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
// @lc code=end

