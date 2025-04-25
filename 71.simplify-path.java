/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String clean(String path) {
        String ret = "/";
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/' && ret.charAt(ret.length() - 1) == '/') {
                continue;
            } else {
                ret += String.valueOf(path.charAt(i));
            }
        }
        if (ret.charAt(ret.length() - 1) == '/') {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }


    public String simplifyPath(String path) {
        String s = clean(path);
        String[] ss = s.split("/");
        Stack<String> stack = new Stack();
        for (int i = 1; i < ss.length; i++) {
            if (ss[i].equals(".") == true) {
                continue;
            }
            if (ss[i].equals("..") == true) {
                if (stack.isEmpty() == false) {
                    stack.pop();
                }
                continue;
            }
            stack.push(ss[i]);
        }
        String ans = "";
        while (stack.isEmpty() == false) {
            ans = "/" + stack.pop() + ans;
        }
        if (ans.equals("") == true) ans = "/";
        return ans;
    }
}
// @lc code=end

