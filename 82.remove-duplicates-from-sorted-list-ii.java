/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Map<Integer, Integer> map = new HashMap();
        ListNode node = head;
        while (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }
        node = new ListNode();
        ListNode ret = node;
        ListNode prev = node;
        boolean isfound = false;

        List<Map.Entry<Integer, Integer>> list = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, (a, b) -> (a.getKey() - b.getKey()));

        
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() == 1) {
                isfound = true;
                node.val = entry.getKey();
                node.next = new ListNode();
                prev = node;
                node = node.next;
            }
        }
        prev.next = null;
        return isfound == true ? ret : null;
    }

}

// @lc code=end

