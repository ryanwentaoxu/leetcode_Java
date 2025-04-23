/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int[] helper(TreeNode node) {
        if (node == null) {
            int[] ret = new int[]{-1, -1};
            return ret;
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);
        if (left[1] == -1 && right[1] == -1) {
            if (ans < 1) ans = 1;
            int[] ret = new int[]{node.val, 1};
            return ret;
        }

        if (left[1] == -1 && right[1] != -1) {
            if (node.val == node.right.val) {
                int[] ret = new int[2];
                ret[0] = node.val;
                ret[1] = 1 + right[1];
                if (ret[1] > ans) ans = ret[1];
                return ret;
            } else {
                if (ans < 1) ans = 1;
                int[] ret = new int[]{node.val, 1};
                return ret;
            }
        }

        if (left[1] != -1 && right[1] == -1) {
            if (node.val == node.left.val) {
                int[] ret = new int[2];
                ret[0] = node.val;
                ret[1] = 1 + left[1];
                if (ret[1] > ans) ans = ret[1];
                return ret;
            } else {
                if (ans < 1) ans = 1;
                int[] ret = new int[]{node.val, 1};
                return ret;
            }
        }

        if (node.left.val != node.val && node.right.val != node.val) {
            if (ans < 1) ans = 1;
            int[] ret = new int[]{node.val, 1};
            return ret;
        }

        if (node.left.val == node.val && node.right.val != node.val) {
            int[] ret = new int[2];
            ret[0] = node.val;
            ret[1] = 1 + left[1];
            if (ret[1] > ans) ans = ret[1];
            return ret;
        }

        if (node.right.val == node.val && node.left.val != node.val) {
            int[] ret = new int[2];
            ret[0] = node.val;
            ret[1] = 1 + right[1];
            if (ret[1] > ans) ans = ret[1];
            return ret;
        }


        int[] ret = new int[2];
        if (left[1] + right[1] + 1 > ans) ans = left[1] + right[1] + 1;
        ret[0] = node.val;
        ret[1] = 1 + Math.max(left[1], right[1]);
        return ret;
    }

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        if (root == null) return 0;
        int[] t = helper(root);
        return ans - 1;
    }
}
// @lc code=end

