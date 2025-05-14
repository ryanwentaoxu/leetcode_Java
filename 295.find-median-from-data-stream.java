/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    int size;


    public MedianFinder() {
        left = new PriorityQueue(Collections.reverseOrder());
        right = new PriorityQueue();
        size = 0;
    }
    
    public void addNum(int num) {
        if (size == 0) {
            right.offer(num);
            size = 1;
            return;
        }

        if (size == 1) {
            int num1 = num;
            int num2 = right.poll();
            left.offer(Math.min(num1, num2));
            right.offer(Math.max(num1, num2));
            size = 2;
            return;
        }

        if (left.size() == right.size()) {
            int numleft = left.poll();
            int numright = right.poll();
            int[] t = {num, numleft, numright};
            Arrays.sort(t);
            left.offer(t[0]);
            right.offer(t[1]);
            right.offer(t[2]);
            size += 1;
        } else {
            int numleft = left.poll();
            int numright = right.poll();
            int[] t = {num, numleft, numright};
            Arrays.sort(t);
            left.offer(t[0]);
            left.offer(t[1]);
            right.offer(t[2]);
            size += 1;
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (double)(left.peek() + right.peek()) / 2.0;
        } else {
            return right.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

