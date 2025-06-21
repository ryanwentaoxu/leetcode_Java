/*
 * @lc app=leetcode id=2476 lang=java
 *
 * [2476] Closest Nodes Queries in a Binary Search Tree
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
    public void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList();
        traverse(root, list);
        List<List<Integer>> ans = new ArrayList();
        for (int num : queries) {
            List<Integer> toAdd = new ArrayList();
            toAdd.add(searchMin(list, num));
            toAdd.add(searchMax(list, num));
            ans.add(toAdd);
        }
        return ans;
    }

    public int searchMin(List<Integer> nums, int val) {
        int left = 0;
        int right = nums.size() - 1;
        int retIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) == val) return nums.get(mid);
            if (nums.get(mid) < val) {
                retIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return retIndex == -1 ? -1 : nums.get(retIndex);
    }

    public int searchMax(List<Integer> nums, int val) {
        int left = 0;
        int right = nums.size() - 1;
        int retIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) == val) return nums.get(mid);
            if (nums.get(mid) > val) {
                retIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return retIndex == -1 ? -1 : nums.get(retIndex);
    }
}
// @lc code=end

