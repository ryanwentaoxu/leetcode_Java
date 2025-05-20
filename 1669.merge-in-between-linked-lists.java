/*
 * @lc app=leetcode id=1669 lang=java
 *
 * [1669] Merge In Between Linked Lists
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        Map<Integer, ListNode> map = new HashMap();
        int count = 0;
        ListNode node = list1;
        ListNode prev = list1;
        while (node != null) {
            if (count == a - 1) {
                map.put(a - 1, node);
            }
            if (count == b + 1) {
                map.put(b + 1, node);
            }
            count += 1;
            prev = node;
            node = node.next;
            if (count == b + 1) {
                prev.next = null;
            }
        }

        ListNode tail2 = list2;
        if (tail2 == null) {
            map.get(a).next = null;
            return list1;
        }
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        map.get(a - 1).next = list2;
        tail2.next = map.get(b + 1);
        return list1;
    }
}
// @lc code=end

