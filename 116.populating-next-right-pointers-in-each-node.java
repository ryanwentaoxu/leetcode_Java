/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Map<Integer, List<Node>> map;
    int maxLayer;

    public void helper(Node node, int layer) {
        if (node == null) return;
        if (map.containsKey(layer) == false) map.put(layer, new ArrayList());
        map.get(layer).add(node);
        if (layer > maxLayer) maxLayer = layer;
        helper(node.left, layer + 1);
        helper(node.right, layer + 1);
    }

    public Node connect(Node root) {
        if (root == null) return null;
        map = new HashMap();
        maxLayer = 0;
        helper(root, 0); 
        for (int i = 0; i <= maxLayer; i++) {
            for (int j = 0; j < map.get(i).size() - 1; j++) {
                map.get(i).get(j).next = map.get(i).get(j + 1);
            }
            map.get(i).get(map.get(i).size() - 1).next = null;
        }
        return root;
    }
}
// @lc code=end

