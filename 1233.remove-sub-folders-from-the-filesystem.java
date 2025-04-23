/*
 * @lc app=leetcode id=1233 lang=java
 *
 * [1233] Remove Sub-Folders from the Filesystem
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;



class TrieNode {
    int R = 26;
    Map<String, TrieNode> container;
    boolean end;

    public TrieNode() {
        container = new HashMap();
        end = false;
    }
}


class Solution {
    TrieNode root;
    List<String> ans;

    public void insert(String ss) {
        TrieNode node = root;
        String[] s = ss.split("/");        
        for (int i = 0; i < s.length; i++) {
            if (node.container.containsKey(s[i]) == false) {
                node.container.put(s[i], new TrieNode());
            }
            node = node.container.get(s[i]);
            if (node.end == true) return;
        }


        node.end = true;
        ans.add("/" + ss);
    }

    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode();
        Arrays.sort(folder);
        ans = new ArrayList<>();
        // record all folder
        for (int i = 0; i < folder.length; i++) {
            String current = folder[i].substring(1, folder[i].length());
            insert(current);
        }
        return ans;
    }
}
// @lc code=end

