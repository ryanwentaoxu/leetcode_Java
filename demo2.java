class TreeNode {
    TreeNode left;
    TreeNode right;
    int leftWeight;
    int rightWeight;
}


public class demo2 {
    public static boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }

    public static int solve(TreeNode node, Map<TreeNode, Integer> map) {
        if (map.containsKey(node)) return map.get(node);
        int cost = 0;
        if (node.left != null) {
            if (isLeaf(node.left)) cost += node.leftWeight;
            else cost += Math.min(solve(node.left, map), node.leftWeight);
        }
        if (node.right != null) {
            if (isLeaf(node.right)) cost += node.rightWeight;
            else cost += Math.min(solve(node.right, map), node.rightWeight);
        }

        map.put(node, cost);
        return cost;
    }
    public static void main(String[] args) {
        System.out.println("????");
    }
}
