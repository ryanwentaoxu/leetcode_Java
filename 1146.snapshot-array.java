/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 */

// @lc code=start

class SnapshotArray {
    int snapId;
    TreeMap<Integer, Integer>[] map;

    public SnapshotArray(int length) {
        snapId = 0;
        map = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            map[i] = new TreeMap();
            map[i].put(snapId, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) { 
        return map[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end

