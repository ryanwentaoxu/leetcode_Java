/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean populate(TreeNode node, List<TreeNode> list, TreeNode target) {
        if (node == null) return false;
        if (node.val == target.val) {
            list.add(node);
            return true;
        }
        boolean ret = populate(node.left, list, target) || populate(node.right, list, target);
        if (ret == true) {
            list.add(0, node);
            return true;
        }
        return false;
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new LinkedList();
        List<TreeNode> path2 = new LinkedList();
        populate(root, path1, p);
        populate(root, path2, q);
        TreeNode ans = root;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i).val == path2.get(i).val) {
                ans = path1.get(i);
            } else {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

