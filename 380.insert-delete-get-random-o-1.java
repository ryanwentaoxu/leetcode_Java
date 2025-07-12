/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rnd;
    int size;

    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
        rnd = new Random();
        size = 0; 
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, size);
        list.add(val);
        size += 1;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        if (size == 1) {
            map.remove(val);
            list.removeLast();
            size -= 1;
        } else {
            int index = map.get(val);
            int tailVal = list.get(size - 1);
            map.put(tailVal, index);
            map.remove(val);
            list.set(index, tailVal);
            list.removeLast();
            size -= 1;
        }
        return true;
    }
    
    public int getRandom() {
        int index = rnd.nextInt(size);
        return list.get(index);
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

