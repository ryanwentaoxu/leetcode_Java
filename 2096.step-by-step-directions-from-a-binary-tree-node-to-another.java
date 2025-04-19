/*
 * @lc app=leetcode id=2096 lang=java
 *
 * [2096] Step-By-Step Directions From a Binary Tree Node to Another
 */

// @lc code=start

import java.util.ArrayList;

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
    public boolean helper(TreeNode node, int target, List<TreeNode> list) {
        if (node == null) return false;
        if (node.val == target) {
            list.add(0, node);
            return true;
        }
        boolean p = helper(node.left, target, list) || helper(node.right, target, list);
        if (p) {
            list.add(0, node);
            return true;
        }
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        boolean p1 = helper(root, startValue, l1);
        boolean p2 = helper(root, destValue, l2);
        int id = 0;
        TreeNode pivot = new TreeNode();
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
            if (l1.get(i).equals(l2.get(i))) {
                pivot = l1.get(i);
                id = i;
            } else {
                break;
            }
        }
        String ret = "";
        for (int i = id; i < l1.size() - 1; i++) {
            ret += "U";
        }
        for (int i = id; i < l2.size() - 1; i++) {
            if (l2.get(i).right != null && l2.get(i).right.equals(l2.get(i + 1))) {
                ret += "R";
            } else {
                ret += "L";
            }
        }
        return ret;
    }
}
// @lc code=end

