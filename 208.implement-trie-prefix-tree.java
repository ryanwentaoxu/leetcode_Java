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

    public TrieNode() {
        this.container = new TrieNode[R];
    }

    public TrieNode get(char c) {
        return container[(int)(c - 'a')];
    }

    public void put(char c) {
        container[(int)(c - 'a')] = new TrieNode();
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
            if (node.get(word.charAt(i)) == null) node.put(word.charAt(i));
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.get(word.charAt(i)) == null) return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd() == true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.get(prefix.charAt(i)) == null) return false;
            node = node.get(prefix.charAt(i));
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
// @lc code=end

