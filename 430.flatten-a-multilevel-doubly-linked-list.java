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
    public Node[] helper(Node head) {
        Node node = head;
        Node tail = head;
        while (node != null) {
            Node nextNode = node.next;
            if (node.child != null) {
                Node[] children = helper(node.child);
                node.child = null;
                node.next = children[0];
                children[0].prev = node;
                if (nextNode == null) {
                    tail = children[1];
                    break;
                } else {
                    nextNode.prev = children[1];
                    children[1].next = nextNode;
                    node = nextNode;
                    tail = nextNode;
                }
            } else {
                tail = node;
                node = nextNode;
            }
            
        }
        return new Node[]{head, tail};
    }
    public Node flatten(Node head) {
        if (head == null) return null;
        Node[] nodes = helper(head);
        return nodes[0];
    }
}
// @lc code=end

