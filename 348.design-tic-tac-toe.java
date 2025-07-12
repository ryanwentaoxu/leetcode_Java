class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiag;


    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        int p = player == 1 ? 1 : -1;
        rows[row] += p;
        cols[col] += p;
        if (row == col) diagonal += p;
        if (row + col + 1 == rows.length) antiDiag += p;
        int n = rows.length;
        if (Math.abs(rows[row]) == n) return player;
        if (Math.abs(cols[col]) == n) return player;
        if (Math.abs(diagonal) == n) return player;
        if (Math.abs(antiDiag) == n) return player;
        return 0; 
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */