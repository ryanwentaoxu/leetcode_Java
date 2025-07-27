/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {
    public String shelper(TreeNode node, String s) {
        if (node == null) {
            s += "null;";
            return s;
        }
        s += node.val;
        s += ";";
        s = shelper(node.left, s);
        s = shelper(node.right, s);
        return s;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = shelper(root, "");
        return s.substring(0, s.length() - 1);
    }

    public TreeNode dhelper(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = dhelper(l);
        root.right = dhelper(l);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> l = new ArrayList();
        for (String s : data.split(";")) l.add(s);
        return dhelper(l);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

