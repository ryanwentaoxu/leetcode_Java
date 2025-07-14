/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack(); 
    }
    
    public int next(int price) {
        int ans = 1;
        while (stack.size() > 0) {
            int[] prev = stack.peek();
            if (prev[0] <= price) {
                ans += prev[1];
                stack.pop();
            } else {
                break;
            }
        }
        stack.push(new int[]{price, ans});
        return ans;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

