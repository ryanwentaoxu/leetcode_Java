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
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Pair<String, Double>> gidWeight = new HashMap();

        // step 1: build the union groups

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double value = values[i];
            union(gidWeight, dividend, divisor, value);
        }

        // step 2 run the evaluaion, with lazy updates in find
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (!gidWeight.containsKey(dividend) || !gidWeight.containsKey(divisor)) {
                results[i] = -1.0;
            } else {
                Pair<String, Double> dividendEntry = find(gidWeight, dividend);
                Pair<String, Double> divisorEntry = find(gidWeight, divisor);

                String dividendGid = dividendEntry.getKey();
                String divisorGid = divisorEntry.getKey();

                Double dividendWeight = dividendEntry.getValue();
                Double divisorWeight = divisorEntry.getValue();

                if (!dividendGid.equals(divisorGid))
                    // case 2). the variables do not belong to the same chain/group
                    results[i] = -1.0;
                else
                    // case 3). there is a chain/path between the variables
                    results[i] = dividendWeight / divisorWeight;
            }
        }
        return results;
    }

    public Pair<String, Double> find(HashMap<String, Pair<String, Double>> gw, String node) {
        if (!gw.containsKey(node)) {
            gw.put(node, new Pair(node, 1.0));
        }
        Pair<String, Double> entry = gw.get(node);
        if (!entry.getKey().equals(node)) {
            Pair<String, Double> p = find(gw, entry.getKey());
            gw.put(node, new Pair(p.getKey(), entry.getValue() * p.getValue()));
        }
        return gw.get(node);
    }
    
    public void union(HashMap<String, Pair<String, Double>> gw, String de, String di, Double value) {
        Pair<String, Double> p1 = this.find(gw, de);
        Pair<String, Double> p2 = this.find(gw, di);

        // they are parent
        String deNode = p1.getKey();
        String diNode = p2.getKey();

        Double deV = p1.getValue();
        Double diV = p2.getValue();

        // update
        if (!deNode.equals(diNode)) {
            gw.put(deNode, new Pair(diNode, value * diV / deV));
        }

        // M / dev
        // N / div

        // (M / dev) * (div / N) * v = 1
    }
}
// @lc code=end

