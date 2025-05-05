/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 * algorithms
 * Medium (46.84%)
 * Likes:    7843
 * Dislikes: 476
 * Total Accepted:    762.3K
 * Total Submissions: 1.6M
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports adding new words and finding if a
 * string matches any previously added string.
 * 
 * Implement the WordDictionary class:
 * 
 * 
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched
 * later.
 * bool search(word) Returns true if there is any string in the data structure
 * that matches word or false otherwise. word may contain dots '.' where dots
 * can be matched with any letter.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input
 * 
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 * 
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 10^4 calls will be made to addWord and search.
 * 
 * 
 */

// @lc code=start
class TrieNode {
    int R = 26;
    TrieNode[] container;
    boolean isEnd;

    public TrieNode() {
        container = new TrieNode[R];
        isEnd = false;    
    }

    public void insert(char c) {
        container[(int)(c - 'a')] = new TrieNode();
    }

    public TrieNode get(char c) {
        return container[(int)(c - 'a')];
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean end() {
        return isEnd;
    }
}


class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.get(c) == null) node.insert(c);
            node = node.get(c);
        }
        node.setEnd();;
    }

    public boolean helper(String word, TrieNode node) {
        if (word == null || word.length() == 0) return node.end();
        boolean ret = false;
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (c == '.') {
                for (int i = 0; i < node.R; i++) {
                    if (node.get((char)('a' + i)) != null) ret = ret || helper(word.substring(j + 1, word.length()), node.get((char)('a' + i)));
                }
                return ret;
            } else {
                if (node.get(c) == null) return false;
                node = node.get(c);
            }
        }
        return node.end();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return helper(word, node);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

