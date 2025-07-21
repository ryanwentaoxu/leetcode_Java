/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {
    int[] array;
    int[] original;
    Random rnd;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.array = nums.clone();
        rnd = new Random();
    }
    
    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    
    public int[] reset() {
        this.array = this.original;
        this.original = this.original.clone();
        return this.array;
    }
    
    public int[] shuffle() {
        int n = this.array.length;
        for (int i = 0; i < n; i++) {
            int index = i + rnd.nextInt(n - i);
            swap(this.array, i, index);
        }
        return this.array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

