/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class TrieNode {
    int R = 26;
    TrieNode[] container;
    boolean end;

    public TrieNode() {
        container = new TrieNode[R];
        end = false;
    }

    public void insert(char c) {
        container[(int)(c - 'a')] = new TrieNode();
    }

    public TrieNode get(char c) {
        return container[(int)(c - 'a')];
    }

    public void setEnd() {
        end = true;
    }

    public boolean isEnd() {
        return end;
    }
}

class Solution {
    TrieNode root;
    public void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.get(c) == null) node.insert(c);
            node = node.get(c);
        }
        node.setEnd();
    }

    public List<Integer> count(TrieNode node) {
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < 26; i++) {
            if (node.container[i] != null) {
                ret.add(i);
            }
        }
        return ret;
    }
    public String longestCommonPrefix(String[] strs) {
        int lenlim = Integer.MAX_VALUE;
        for (String s : strs) lenlim = Math.min(lenlim, s.length()); 

        root = new TrieNode();
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }
        TrieNode node = root;
        List<List<Integer>> tmp = new ArrayList();
        List<Integer> t = count(node);
        while (t.size() == 1) {
            tmp.add(t);
            int index = t.get(0);
            node = node.get((char)('a' + index));
            t = count(node);
        }
        String ans = "";
        for (int i = 0; i < Math.min(lenlim, tmp.size()); i++) {
            List<Integer> current = tmp.get(i);
            ans += (char)(current.get(0) + 'a');
        }
        return ans;
    }
}
// @lc code=end

