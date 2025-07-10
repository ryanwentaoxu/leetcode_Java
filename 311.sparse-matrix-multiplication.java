class Solution {
    public int multi(int[] l1, int[] l2) {
        int ans = 0;
        for (int i = 0; i < l1.length; i++) ans += l1[i] * l2[i];
        return ans;
    }

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length;
        int col1 = mat1[0].length;
        int row2 = mat2.length;
        int col2 = mat2[0].length;
        int[][] ret = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                int[] l1 = mat1[i];
                int[] l2 = new int[row2];
                for (int k = 0; k < row2; k++) {
                    l2[k] = mat2[k][j];
                }
                ret[i][j] = multi(l1, l2);
            }
        }
        return ret;
    }
}