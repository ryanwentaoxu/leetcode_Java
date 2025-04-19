/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

class HitCounter {

    Deque<Pair<Integer, Integer>> container;

    public HitCounter() {
        container = new LinkedList<>();    
    }
    
    public void hit(int timestamp) {
        if (container.isEmpty() == false) {
            Pair<Integer, Integer> p = container.peekLast();
            int val = p.getValue();
            if (p.getKey() == timestamp) {
                val += 1;
                container.pollLast();
                container.offerLast(new Pair(timestamp, val));
            } else {
                container.offerLast(new Pair(timestamp, 1));
            }
        } else {
            container.offerLast(new Pair(timestamp, 1));
        }
    }
    
    public int getHits(int timestamp) {
        if (container.isEmpty() == true) return 0;
        while (container.isEmpty() == false && container.peekFirst().getKey() <= timestamp - 300) {
            container.pollFirst();
        }
        if (container.isEmpty() == true) return 0;
        int ret = 0;
        for (Pair<Integer, Integer> p : container) {
            ret += p.getValue();
        }
        return ret;
    }

}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
// @lc code=end

