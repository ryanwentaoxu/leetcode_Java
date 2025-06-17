/*
 * @lc app=leetcode id=359 lang=java
 *
 * [359] Logger Rate Limiter
 */

// @lc code=start
class Logger {
    Queue<Integer> container;
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap();
        container = new LinkedList();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message) == false) {
            map.put(message, timestamp);
            while (container.size() > 0 && container.peek() < timestamp - 10) {
                container.poll();
            }
            container.offer(timestamp);
            return true;
        } else {
            int t = map.get(message);
            boolean ret = false;
            if (t + 10 <= timestamp) {
                ret = true;
                map.put(message, timestamp);
            }
            while (container.size() > 0 && container.peek() < timestamp - 10) {
                container.poll();
            }
            container.offer(timestamp);
            return ret;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
// @lc code=end

