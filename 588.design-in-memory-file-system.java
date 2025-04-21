/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class File {
    boolean isFile = false;
    String content = "";
    Map<String, File> map = new HashMap<>();
}

class FileSystem {
    File root;

    public FileSystem() {
        root = new File();    
    }
    
    public List<String> ls(String path) {
        if (path.equals("/") == true) {
            List<String> ret = new ArrayList<>();
            for (Map.Entry<String, File> entry : root.map.entrySet()) {
                ret.add(entry.getKey());
            }
            Collections.sort(ret);
            return ret;
        }
        String[] paths = path.split("/");
        List<String> ret = new ArrayList<>();
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            node = node.map.get(paths[i]);
        }
        if (node.isFile == true) {
            ret.add(paths[paths.length - 1]);
        } else {
            for (Map.Entry<String, File> entry : node.map.entrySet()) {
                ret.add(entry.getKey());
            }
        }
        Collections.sort(ret);
        return ret;
    }
    
    public void mkdir(String path) {
        String[] paths = path.split("/");
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            if (node.map.containsKey(paths[i]) == false) node.map.put(paths[i], new File());
            node = node.map.get(paths[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            if (node.map.containsKey(paths[i]) == false) node.map.put(paths[i], new File());
            node = node.map.get(paths[i]);
        }
        node.isFile = true;
        node.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            if (node.map.containsKey(paths[i]) == false) node.map.put(paths[i], new File());
            node = node.map.get(paths[i]);
        }
        return node.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
// @lc code=end

