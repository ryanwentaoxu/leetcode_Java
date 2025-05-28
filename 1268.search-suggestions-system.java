/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class TrieNode {
    int R;
    TrieNode[] container;
    boolean end;

    public TrieNode() {
        R = 26;
        container = new TrieNode[R];
        end = false;
    }

    public void insert(char c) {
        this.container[(int) (c - 'a')] = new TrieNode();
    }

    public TrieNode get(char c) {
        return this.container[(int) (c - 'a')];
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd() {
        this.end = true;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.get(word.charAt(i)) == null) {
                node.insert(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public List<String> searchFollowing(String word, TrieNode node) {
        List<String> ret = new ArrayList();
        for (int i = 0; i < node.R; i++) {
            TrieNode current = node.container[i];
            if (current == null) continue;
            List<String> currentList = searchFollowing(word + String.valueOf((char)('a' + i)), current);
            if (current.isEnd()) ret.add(word + String.valueOf((char)('a' + i)));
            ret.addAll(currentList);
        }
        return ret;
    }

    public List<String> search(String word) {
        List<String> ret = new ArrayList();
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < w.length; i++) {
            node = node.get(w[i]);
            if (node == null) return new ArrayList();
        }
        if (node.end == true) ret.add(word);
        List<String> l = searchFollowing(word, node);
        ret.addAll(l);
        Collections.sort(ret);
        if (ret.size() > 3) {
            ret = ret.subList(0, 3);
        }
        return ret;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();
        for (String product : products) {
            t.add(product);
        }
        List<List<String>> ans = new ArrayList();
        for (int i = 0; i < searchWord.length(); i++) {
            String current = searchWord.substring(0, i + 1);
            List<String> toAdd = t.search(current);
            if (toAdd != null) ans.add(t.search(current));
        }
        return ans;
    }
}
// @lc code=end

