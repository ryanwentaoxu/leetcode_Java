class Solution {
    public Map<Integer, List<Pair<Integer, Integer>>> compress(int[][] matrix) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    List<Pair<Integer, Integer>> list = map.getOrDefault(i, new ArrayList());
                    list.add(new Pair(matrix[i][j], j));
                    map.put(i, list);
                }
            }
        }
        return map;
    }
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        Map<Integer, List<Pair<Integer, Integer>>> cm1 = compress(mat1);
        Map<Integer, List<Pair<Integer, Integer>>> cm2 = compress(mat2);
        int[][] ret = new int[mat1.length][mat2[0].length];
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : cm1.entrySet()) {
            int row1 = entry.getKey();
            for (Pair<Integer, Integer> p : entry.getValue()) {
                int el1 = p.getKey();
                int row2 = p.getValue();
                List<Pair<Integer, Integer>> tmp = cm2.getOrDefault(row2, new ArrayList());
                for (Pair<Integer, Integer> p2 : tmp) {
                    int el2 = p2.getKey();
                    int col2 = p2.getValue();
                    ret[row1][col2] += el1 * el2;
                }
            }
        }
        return ret;
    }
}