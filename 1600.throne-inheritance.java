/*
 * @lc app=leetcode id=1600 lang=java
 *
 * [1600] Throne Inheritance
 */

// @lc code=start

import java.util.ArrayList;

class ThroneInheritance {
    String kingName;
    Map<String, Boolean> dead;
    Map<String, List<String>> children;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        this.dead = new HashMap();
        this.children = new HashMap();
        this.children.put(kingName, new ArrayList<>());
        this.dead.put(kingName, false);
    }
    
    public void birth(String parentName, String childName) {
        if (children.containsKey(parentName) == false) {
            children.put(parentName, new ArrayList());
        }
        children.get(parentName).add(childName);
        dead.put(parentName, false);
        dead.put(childName, false);
    }
    
    public void death(String name) {
        this.dead.put(name, true);
    }

    public void dfs(String node, List<String> l) {
        if (this.dead.get(node) == false) l.add(node);
        if (!this.children.containsKey(node)) return;
        for (int i = 0; i < this.children.get(node).size(); i++) {
            dfs(this.children.get(node).get(i), l);
        }
        return;
    }


    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList();
        dfs(kingName, ans);
        return ans;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
// @lc code=end

