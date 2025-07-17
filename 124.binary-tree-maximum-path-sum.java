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
        if (node == null) return 0;
        int leftMax = helper(node.left);
        int rightMax = helper(node.right);
        ans = Math.max(ans, node.val);
        ans = Math.max(ans, node.val + leftMax);
        ans = Math.max(ans, node.val + leftMax + rightMax);
        ans = Math.max(ans, node.val + rightMax);
        return Math.max(node.val, Math.max(node.val + rightMax, node.val + leftMax));
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
}