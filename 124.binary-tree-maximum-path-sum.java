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
    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        
        if (left + right + node.val > ans) {
            ans = Integer.max(ans, left + right + node.val);
        }
        
        if (node.val + left > node.val + right) {
            if (node.val + left >= 0) {
                return node.val + left;
            }
            return 0;
        }
        if (node.val + right >= 0) {
            return node.val + right;
        }
        return 0;
    }

    public int maxPathSum(TreeNode root) {
        this.ans = Integer.MIN_VALUE;
        int ret = helper(root);
        return ans;     
    }
}