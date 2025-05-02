/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.List;

class MinStack {
    List<Integer> l;
    List<Integer> min;
    int minVal;

    public MinStack() {
        l = new ArrayList();
        min = new ArrayList();
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val < minVal) minVal = val;
        l.add(val);
        min.add(minVal);
    }
    
    public void pop() {
        if (l.size() == 0) return;
        l.remove(l.size() - 1);
        if (min.size() == 1) minVal = Integer.MAX_VALUE;
        else minVal = min.get(min.size() - 2);
        min.remove(min.size() - 1);
    }
    
    public int top() {
        return l.get(l.size() - 1);
    }
    
    public int getMin() {
        return min.get(min.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

