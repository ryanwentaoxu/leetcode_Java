/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 */

// @lc code=start

class File {
    String content = "";
    boolean isFile = false;
    Map<String, File> sub;

    public File() {
        sub = new HashMap();
    }
}

class FileSystem {
    File root;
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        List<String> ret = new ArrayList();
        if (path.equals("/")) {
            for (Map.Entry<String, File> f : root.sub.entrySet()) {
                ret.add(f.getKey());
            }
            Collections.sort(ret);
            return ret;
        }

        String[] paths = path.split("/");
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            String current = paths[i];
            node = node.sub.get(current);
        }
        if (node.isFile) ret.add(paths[paths.length - 1]);
        else {
            for (Map.Entry<String, File> f : node.sub.entrySet()) {
                ret.add(f.getKey());
            }
        }
        Collections.sort(ret);
        return ret;
    }
    
    public void mkdir(String path) {
        String[] paths = path.split("/");
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            if (node.sub.containsKey(paths[i]) == false) node.sub.put(paths[i], new File());
            node = node.sub.get(paths[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            if (node.sub.containsKey(paths[i]) == false) node.sub.put(paths[i], new File());
            node = node.sub.get(paths[i]);
        }
        node.isFile = true;
        node.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        File node = root;
        for (int i = 1; i < paths.length; i++) {
            if (node.sub.containsKey(paths[i]) == false) node.sub.put(paths[i], new File());
            node = node.sub.get(paths[i]);
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

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
// @lc code=end

