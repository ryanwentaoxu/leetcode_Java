/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/


class Solution {
    public Node[] helper(Node node) {
        Node current = node;
        Node head = current;
        Node tail = head;
        while (current != null) {
            Node next = current.next;
            if (current.child != null) {
                Node[] children = helper(current.child);
                current.child = null;
                current.next = children[0];
                children[0].prev = current;
                if (next == null) {
                    tail = children[1];
                    break;
                } else {
                    children[1].next = next;
                    next.prev = children[1];
                    tail = next;
                    current = next;
                }
            } else {
                tail = current;
                current = next;
            }
        }
        return new Node[]{head, tail};
    }
    public Node flatten(Node head) {
        if (head == null) return null;
        Node node = head;
        Node[] tmp = helper(node);
        return tmp[0];
    }
}
// @lc code=end

