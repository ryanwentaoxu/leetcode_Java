/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class TrieNode {
    TrieNode[] container;
    int R = 26;
    boolean end = false;

    TrieNode(){
        container = new TrieNode[R];
    }

    public void insert(char c) {
        container[(int)(c - 'a')] = new TrieNode();
    }

    public TrieNode get(char c) {
        return container[(int)(c - 'a')];
    }

    public void setEnd() {
        this.end = true;
    }

    public boolean isEnd() {
        return this.end;
    }
    
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (node.get(current) == null) node.insert(current);
            node = node.get(current);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            node = node.get(current);
            if (node == null) return false;
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            node = node.get(current);
            if (node == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

