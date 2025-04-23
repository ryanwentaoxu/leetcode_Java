/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

class TimeMap {
    Map<String, List<Pair<Integer, String>>> dict;

    public TimeMap() {
        dict = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (dict.containsKey(key) == false) {
            dict.put(key, new ArrayList());
        }
        dict.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (dict.containsKey(key) == false) return "";
        int length = dict.get(key).size();
        if (timestamp >= dict.get(key).get(length - 1).getKey()) {
            return dict.get(key).get(length - 1).getValue();
        }
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Pair<Integer, String> p = dict.get(key).get(mid);
            if (p.getKey() > timestamp) {
                right = mid - 1;
            } else {
                if (dict.get(key).get(mid + 1).getKey() > timestamp) {
                    return dict.get(key).get(mid).getValue();
                }
                if (dict.get(key).get(mid).getKey() == timestamp) {
                    return dict.get(key).get(mid).getValue();
                }
                left = mid + 1;
            }
        }
        if (right <= 0) return "";
        return dict.get(key).get(right).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

