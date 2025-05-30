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
        LinkedList<TreeNode> queue = new LinkedList();
        Set<Integer> td = new HashSet();
        for (int n : to_delete) {
            td.add(n);
        }
        List<TreeNode> ans = new ArrayList();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode current = queue.pollFirst();
            
            if (current.left != null) {
                queue.add(current.left);
                if (td.contains(current.left.val)) {
                    current.left = null;
                }
            }

            if (current.right != null) {
                queue.add(current.right);
                if (td.contains(current.right.val)) {
                    current.right = null;
                }
            }

            if (td.contains(current.val)) {
                if (current.left != null) {
                    ans.add(current.left);
                }
                if (current.right != null) {
                    ans.add(current.right);
                }
            }
        }

        if (!td.contains(root.val)) ans.add(root);

        return ans;
    }
}
// @lc code=end

