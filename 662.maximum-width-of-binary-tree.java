/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    Map<Integer, List<Integer>> map;
    int ans;
    public void populate(TreeNode node, int row, int col) {
        if (node == null) return;
        if (!map.containsKey(row)) map.put(row, new ArrayList());
        map.get(row).add(col);
        ans = Math.max(ans, col - map.get(row).get(0));
        populate(node.left, row + 1, col * 2);
        populate(node.right, row + 1, col * 2 + 1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap();
        ans = 0;
        populate(root, 0, 0);
        return ans + 1;
    }
}
// @lc code=end

