/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        ListNode node = slow;
        ListNode prev = null;
        ListNode next;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        ListNode node1 = head;
        ListNode node2 = prev;

        while (node2.next != null) {
            ListNode next1 = node1.next;
            node1.next = node2;

            ListNode next2 = node2.next;
            node2.next = next1;

            node1 = next1;
            node2 = next2;
        }
    }
}
// @lc code=end

