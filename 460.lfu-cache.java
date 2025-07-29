/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class LFUCache {
    Map<Integer, LinkedHashSet<Integer>> freq;
    Map<Integer, Pair<Integer, Integer>> cache;
    int capacity;
    int minf;

    public LFUCache(int capacity) {
        minf = 0;
        this.capacity = capacity;
        freq = new HashMap();
        cache = new HashMap();
    }
    
    public int get(int key) {
        // System.out.println("???");
        if (!cache.containsKey(key)) return -1;
        Pair<Integer, Integer> target = cache.get(key);
        int f = target.getKey();
        int v = target.getValue();
        LinkedHashSet<Integer> allKeys = freq.get(f);
        allKeys.remove(key);
        if (allKeys.isEmpty()) {
            freq.remove(f);
            if (f == minf) minf += 1;
        }
        f += 1;
        LinkedHashSet<Integer> nextKeys = freq.getOrDefault(f, new LinkedHashSet());
        nextKeys.add(key);
        freq.put(f, nextKeys);
        cache.put(key, new Pair(f, v));
        return v;
    }
    
    public void put(int key, int value) {
        // System.out.println("!!!!");
        if (cache.containsKey(key)) {
            // System.out.println("!!!!");
            get(key);
            Pair<Integer, Integer> current = cache.get(key);
            cache.put(key, new Pair(current.getKey(), value));
            return;
        } else {
            if (cache.size() == capacity) {
                LinkedHashSet<Integer> allKeys = freq.get(minf);
                int toDelete = allKeys.iterator().next();
                cache.remove(toDelete);
                allKeys.remove(toDelete);
                if (allKeys.size() == 0) freq.remove(minf);
            }
            minf = 1;
            cache.put(key, new Pair(1, value));
            if (!freq.containsKey(minf)) freq.put(minf, new LinkedHashSet());
            freq.get(minf).add(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

