/*
 * @lc app=leetcode id=2487 lang=java
 *
 * [2487] Remove Nodes From Linked List
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
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Stack<Integer> stack = new Stack();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                stack.push(list.get(i));
            } else {
                if (list.get(i) >= stack.peek()) {
                    stack.push(list.get(i));
                }
            }
        }
        ListNode ans = new ListNode(stack.peek());
        stack.pop();
        node = ans;
        while (stack.size() > 0) {
            node.next = new ListNode(stack.peek());
            stack.pop();
            node = node.next;
        }
        return ans;
    }
}
// @lc code=end

