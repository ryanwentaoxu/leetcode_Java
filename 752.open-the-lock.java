/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Lock {
    int n1;
    int n2;
    int n3;
    int n4;

    public Lock(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n1, n2, n3, n4);
    }

    
    @Override
    public boolean equals(Object l2) {
        if (this == l2) {
            return true;
        }
        if (l2 == null || getClass() != l2.getClass()) {
            return false;
        }
        Lock ll2 = (Lock) l2;
        if (n1 != ll2.n1) return false;
        if (n2 != ll2.n2) return false;
        if (n3 != ll2.n3) return false;
        if (n4 != ll2.n4) return false;

        return true;
    }
}

class Solution {
    public List<Lock> getAll(Lock l) {
        List<Lock> lock = new ArrayList();

        int nn1 = l.n1;
        int nn2 = l.n2;
        int nn3 = l.n3;
        int nn4 = l.n4;

        lock.add(new Lock(nn1 - 1 >= 0 ? nn1 - 1 : 9, nn2, nn3, nn4));
        lock.add(new Lock(nn1 + 1 <= 9 ? nn1 + 1 : 0, nn2, nn3, nn4));
        lock.add(new Lock(nn1, nn2 - 1 >= 0 ? nn2 - 1 : 9, nn3, nn4));
        lock.add(new Lock(nn1, nn2 + 1 <= 9 ? nn2 + 1 : 0, nn3, nn4));
        lock.add(new Lock(nn1, nn2, nn3 - 1 >= 0 ? nn3 - 1 : 9, nn4));
        lock.add(new Lock(nn1, nn2, nn3 + 1 <= 9 ? nn3 + 1 : 0, nn4));
        lock.add(new Lock(nn1, nn2, nn3, nn4 - 1 >= 0 ? nn4 - 1 : 9));
        lock.add(new Lock(nn1, nn2, nn3, nn4 + 1 <= 9 ? nn4 + 1 : 0));
        
        return lock;
    }

    public int openLock(String[] deadends, String target) {

        Set<Lock> dead = new HashSet();

        for (String s : deadends) {
            System.out.println(s);
            int n1 = Integer.valueOf(s.charAt(0) - '0');
            int n2 = Integer.valueOf(s.charAt(1) - '0');
            int n3 = Integer.valueOf(s.charAt(2) - '0');
            int n4 = Integer.valueOf(s.charAt(3) - '0');
            dead.add(new Lock(n1, n2, n3, n4));
        }

        Set<Lock> visited = new HashSet();
        Lock start = new Lock(0, 0, 0, 0);

        LinkedList<Lock> queue = new LinkedList();
        Lock end = new Lock(Integer.valueOf(target.charAt(0) - '0'), Integer.valueOf(target.charAt(1) - '0'), Integer.valueOf(target.charAt(2) - '0'), Integer.valueOf(target.charAt(3) - '0'));

        queue.add(start);
        if (dead.contains(start)) return -1;
        if (start.equals(end)) return 0;
        visited.add(start);
        int ans = 0;

        // BFS
        while (queue.size() != 0) {
            int lim = queue.size();
            ans += 1;
            for (int i = 0; i < lim; i++) {
                Lock current = queue.pollFirst();
                List<Lock> neighs = getAll(current);
                for (Lock l : neighs) {
                    if (dead.contains(l) == false && visited.contains(l) == false) {
                        if (l.equals(end)) {
                            return ans;
                        }
                        visited.add(l);
                        queue.offerLast(l);
                    }
                } 
            }
        }
        return -1;
    }
}
// @lc code=end

