/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }
        if (!found == true) this.bucket.add(new Pair(key, value));
    }

    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

class MyHashMap {
    private int key_space;
    private List<Bucket> hash_table;

    public MyHashMap() {
        key_space = 2069;
        hash_table = new ArrayList();
        for (int i = 0; i < key_space; i++) {
            hash_table.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int index = key % key_space;
        hash_table.get(index).update(key, value);
    }
    
    public int get(int key) {
        int index = key % key_space;
        return hash_table.get(index).get(key);
    }
    
    public void remove(int key) {
        int index = key % key_space;
        hash_table.get(index).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

