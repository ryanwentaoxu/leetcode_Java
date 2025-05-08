/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (62.97%)
 * Likes:    9739
 * Dislikes: 1025
 * Total Accepted:    591.2K
 * Total Submissions: 938.9K
 * Testcase Example:  '[["a","b"],["b","c"]]\n' +
  '[2.0,3.0]\n' +
  '[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
 * single variable.
 * 
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * j^th query where you must find the answer for Cj / Dj = ?.
 * 
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 * 
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 * 
 * Note: The variables that do not occur in the list of equations are
 * undefined, so the answer cannot be determined for them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation: 
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * 
 * Example 2:
 * 
 * 
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values =
 * [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 * 
 * 
 */

// @lc code=start
class Solution {
    Map<String, Pair<String, Double>> map;
    Set<String> set;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap();
        set = new HashSet();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String de = equation.get(0);
            String di = equation.get(1);
            set.add(de);
            set.add(di);
            union(de, di, value);
        }
        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String de = queries.get(i).get(0);
            String di = queries.get(i).get(1);
            if (!set.contains(de) || !set.contains(di)) {
                ret[i] = -1.0;
                continue;
            }
            String deP = find(de).getKey();
            String diP = find(di).getKey();
            if (!deP.equals(diP)) ret[i] = -1;
            else {
                ret[i] = find(de).getValue() / find(di).getValue();
            }
        }
        return ret;
    }

    public Pair<String, Double> find(String node) {
        if (!map.containsKey(node)) {
            map.put(node, new Pair(node, 1.0));
        }
        Pair<String, Double> p = map.get(node);
        if (!p.getKey().equals(node)) {
            Pair<String, Double> pp = find(p.getKey());
            map.put(node, new Pair(pp.getKey(), pp.getValue() * p.getValue()));
        }
        return map.get(node);
    }

    public void union(String de, String di, double value) {
        Pair<String, Double> deP = find(de);
        Pair<String, Double> diP = find(di);
        if (deP.getKey().equals(diP.getKey())) return;
        String deId = deP.getKey();
        String diId = diP.getKey();
        Double deV = deP.getValue();
        Double diV = diP.getValue();
        map.put(deId, new Pair(diId, value * diV / deV));
    }


}

    