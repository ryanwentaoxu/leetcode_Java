/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        int maxId = -1;
        int swapId1 = -1;
        int swapId2 = -1;
        int index = (String.valueOf(num).toCharArray()).length - 1;
        char[] numc = String.valueOf(num).toCharArray();
        while (index >= 0) {
            if (maxId == -1 || (numc[index] - '0') > (numc[maxId] - '0')) {
                maxId = index;
            } else if (numc[index] - '0' < numc[maxId] - '0') {
                swapId1 = index;
                swapId2 = maxId;
            }
            index -= 1;
        }
        if (swapId1 != -1 && swapId2 != -1) {
            char[] n = String.valueOf(num).toCharArray();
            char n1 = n[swapId1];
            n[swapId1] = n[swapId2];
            n[swapId2] = n1;
            return Integer.parseInt(String.valueOf(n));
        }
        return num;
    }
}
// @lc code=end

