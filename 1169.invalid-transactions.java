/*
 * @lc app=leetcode id=1169 lang=java
 *
 * [1169] Invalid Transactions
 */

// @lc code=start
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ret = new ArrayList();
        Map<String, List<Transaction>> map = new HashMap();
        for (String t : transactions) {
            String[] tt = t.split(",");
            Transaction current = new Transaction(tt[0], tt[3], Integer.parseInt(tt[2]), Integer.parseInt(tt[1]));
            List<Transaction> l = map.getOrDefault(tt[0], new ArrayList());
            l.add(current);
            map.put(tt[0], l);
        }

        for (String t : transactions) {
            String[] tt = t.split(",");
            Transaction current = new Transaction(tt[0], tt[3], Integer.parseInt(tt[2]), Integer.parseInt(tt[1]));
            List<Transaction> l = map.get(tt[0]);
            boolean result = valid(l, current);
            if (!result) {
                ret.add(t);
            }
        }
        return ret;
    }

    public boolean valid(List<Transaction> trans, Transaction t) {
        if (t.amount > 1000) return false;
        for (Transaction tt : trans) {
            if (!tt.isValid(t)) return false;
        }
        return true;
    }
}

class Transaction {
    String name;
    String city;
    int amount;
    int time;

    Transaction(String name, String city, int amount, int time) {
        this.name = name;
        this.city = city;
        this.amount = amount;
        this.time = time;
    }

    public boolean isValid(Transaction other) {
        if (this.name.equals(other.name) && !this.city.equals(other.city)) {
            return Math.abs(this.time - other.time) <= 60 ? false : true;
        }
        return true;
    }
}
// @lc code=end

