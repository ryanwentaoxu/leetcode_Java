/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    // Map<TreeNode, Pair<Integer, Integer>> map;
    Map<Integer, List<Pair<Integer, Integer>>> map;
    int maxCol;
    int minCol;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap();
        maxCol = Integer.MIN_VALUE;
        minCol = Integer.MAX_VALUE; 
        populate(root, 0, 0);
        List<List<Integer>> ret = new ArrayList();
        Comparator<Pair<Integer, Integer>> c = new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() == o2.getKey()) return o1.getValue() - o2.getValue();
                return o1.getKey() - o2.getKey();
            }
        };
        for (int i = minCol; i <= maxCol; i++) {
            List<Pair<Integer, Integer>> current = map.get(i);
            Collections.sort(current, c);
            List<Integer> toAdd = new ArrayList();
            for (Pair<Integer, Integer> p : current) toAdd.add(p.getValue());
            ret.add(toAdd);
        }
        return ret;
    }

    public void populate(TreeNode node, int row, int col) {
        if (node == null) return;
        maxCol = Math.max(maxCol, col);
        minCol = Math.min(minCol, col);
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList());
        }
        map.get(col).add(new Pair(row, node.val));
        populate(node.left, row + 1, col - 1);
        populate(node.right, row + 1, col + 1);
    }
}
// @lc code=end

