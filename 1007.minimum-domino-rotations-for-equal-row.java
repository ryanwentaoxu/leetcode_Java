/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotations = check(tops[0], tops, bottoms, n);
        if (rotations == -1) return check(bottoms[0], tops, bottoms, n);
        return rotations;
    }

    public int check(int x, int[] A, int[] B, int n) {
        int rotations_a = 0;
        int rotations_b = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) rotations_a += 1;
            else if (B[i] != x) rotations_b += 1;
        }

        return Math.min(rotations_a, rotations_b);
    }
}
// @lc code=end

