/*
 * @lc app=leetcode id=1352 lang=java
 *
 * [1352] Product of the Last K Numbers
 */

// @lc code=start
class ProductOfNumbers {
    int size;
    List<Integer> product = new ArrayList();
    public ProductOfNumbers() {
        size = 0;
        product.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            this.product = new ArrayList();
            this.product.add(1);
            this.size = 0;
        } else {
            this.product.add(this.product.get(size) * num);
            this.size += 1;
        }
    }
    
    public int getProduct(int k) {
        if (k > this.size) return 0;
        return this.product.get(this.size) / this.product.get(this.size - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end

