/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class TrieNode {
    String word;
    Map<Character, TrieNode> map;
    public TrieNode() {
        word = null;
        map = new HashMap();
    }
}

class Solution {
    TrieNode root;
    char[][] board;
    List<String> ans;
    public void backtrack(int row, int col, TrieNode node, TrieNode parent) {
        if (!(node.word == null)) {
            ans.add(node.word);
            node.word = null;
        }
        char letter = this.board[row][col];
        this.board[row][col] = '#';

        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, -1, 1};


        for (int i = 0; i < 4; i++) {

            if (row + x[i] < 0 || row + x[i] >= this.board.length || col + y[i] < 0 || col + y[i] >= this.board[0].length) {
                continue;
            }

            if (node.map.containsKey(this.board[row + x[i]][col + y[i]]) == true) {
                backtrack(row + x[i], col + y[i], node.map.get(this.board[row + x[i]][col + y[i]]), node);
            }
        }

        this.board[row][col] = letter;

        if (node.map.isEmpty() == true) {
            parent.map.remove(letter);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        this.board = board;
        ans = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char c : words[i].toCharArray()) {
                if (node.map.containsKey(c) == false) node.map.put(c, new TrieNode());
                node = node.map.get(c);
            }
            node.word = words[i];
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.map.containsKey(board[i][j]) == true) backtrack(i, j, root.map.get(board[i][j]), root);
            }
        }

        return ans;
    }
}
// @lc code=end

