/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList();
        populate(root, 0);
        return ans;
    }
    public void populate(TreeNode node, int row) {
        if (node == null) return;
        if (ans.size() <= row) {
            ans.add(new ArrayList());
        }
        ans.get(row).add(node.val);
        populate(node.left, row + 1);
        populate(node.right, row + 1);
    }
}
// @lc code=end

