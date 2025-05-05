/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    List<Integer> container;
    Map<Integer, Integer> map;
    int size;
    Random rnd;

    public RandomizedSet() {
        size = 0;
        container = new ArrayList();
        map = new HashMap();
        rnd = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        container.add(size, val);
        map.put(val, size);
        size++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        if (size == 1) {
            map.remove(val);
            size--;
        } else {
            int idx = map.get(val);
            map.remove(val);
            if (idx == size - 1) {
                size --;
                return true;
            }
            int tail = container.get(size - 1);
            container.set(idx, tail);
            map.put(tail, idx);
            size--;
        }
        return true;
    }
    
    public int getRandom() {
        return container.get(rnd.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

