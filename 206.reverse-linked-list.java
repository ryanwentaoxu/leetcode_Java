/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<Integer> stack = new Stack();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        ListNode ret = new ListNode();
        ListNode prev = ret;
        ListNode ans = ret;
        while (stack.size() != 0) {
            ret.val = stack.pop();
            ret.next = new ListNode();
            prev = ret;
            ret = ret.next;
        }
        prev.next = null;
        return ans;
    }
}
// @lc code=end

