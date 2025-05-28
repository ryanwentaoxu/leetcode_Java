/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator<Integer> c = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (Math.abs(a - x) == Math.abs(b - x)) {
                    return a.compareTo(b);
                }
                return Math.abs(a - x) - Math.abs(b - x); 
            }
        };
        List<Integer> l = new ArrayList();
        for (int a : arr) l.add(a);
        Collections.sort(l, c);
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < Math.min(k, l.size()); i++) {
            ret.add(l.get(i));
        }
        Collections.sort(ret);
        return ret;
    }
}
// @lc code=end

