/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start

class Solution {
    List<Integer> sumList;
    int sumVal;
    Random rnd;

    public Solution(int[] w) {
        sumList = new ArrayList();
        sumVal = 0;
        rnd = new Random();

        for (int i = 0; i < w.length; i++) {
            sumList.add(sumVal);
            sumVal += w[i];    
        }
        sumList.add(sumVal);
    }
    
    public int pickIndex() {
        double v = rnd.nextDouble(sumVal);
        int left = 0;
        int right = sumList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sumList.get(mid) <= v && sumList.get(mid + 1) > v) return mid;
            if (sumList.get(mid) > v) {
                right = mid - 1;
                continue;
            } else if (sumList.get(mid) < v) {
                left = mid + 1;
                continue;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

