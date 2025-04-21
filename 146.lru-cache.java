/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Node {
    Node prev;
    Node next;
    int key;
    int val;
}

class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void add(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    public int get(int key) {
        if (map.containsKey(key) == false) return -1;
        Node target = map.get(key);
        remove(target);
        add(target);
        return target.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key) == true) {
            Node target = map.get(key);
            remove(target);
            target.val = value;
            add(target);
        } else {
            if (size == capacity) {
                int k = head.next.key;
                map.remove(k);
                remove(head.next);
                size -= 1;
            } 
            size += 1;
            Node target = new Node();
            target.key = key;
            target.val = value;
            add(target);
            map.put(key, target);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

