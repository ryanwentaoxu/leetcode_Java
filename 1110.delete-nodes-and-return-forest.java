/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> td = new HashSet();
        for (int n : to_delete) {
            td.add(n);
        }

        List<TreeNode> ret = new ArrayList();

        LinkedList<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            if (node.left != null) {
                q.addLast(node.left);
                if (td.contains(node.left.val)) {
                    node.left = null;
                }
            }
            
            if (node.right != null) {
                q.addLast(node.right);
                if (td.contains(node.right.val)) {
                    node.right = null;
                }
            }

            if (td.contains(node.val)) {
                if (node.left != null) {
                    ret.add(node.left);
                }
                if (node.right != null) {
                    ret.add(node.right);
                }
            }
        }

        if (!td.contains(root.val)) ret.add(root);

        return ret;
    }
}
// @lc code=end

