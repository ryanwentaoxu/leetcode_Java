/*
 * @lc app=leetcode id=1472 lang=java
 *
 * [1472] Design Browser History
 */

// @lc code=start
class BrowserHistory {
    List<String> his = new ArrayList();
    int current;
    int size;
    public BrowserHistory(String homepage) {
        his = new ArrayList();
        his.add(homepage);
        current = 0;
        size = 1;    
    }
    
    public void visit(String url) {
        if (his.size() == current + 1) {
            his.add(url);
            current += 1;
            size += 1;
        } else {
            his.set(current + 1, url);
            current = current + 1;
            size = current + 1;
        }
    }
    
    public String back(int steps) {
        if (current < steps) {
            current = 0;
        } else {
            current -= steps;
        }
        return his.get(current);
    }
    
    public String forward(int steps) {
        if (current + steps <= size - 1) {
            current += steps;
        } else {
            current = size - 1;
        }
        return his.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end

