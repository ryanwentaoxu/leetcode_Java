class Solution {

    public int[] prefixTable(String s) {
        int[] ret = new int[s.length()];
        int length = 0;
        for (int i = 1; i < s.length(); i++) {
            while (length > 0 && s.charAt(i) != s.charAt(length)) {
                length = ret[length - 1];
            }
            if (s.charAt(i) == s.charAt(length)) {
                length += 1;
            }
            ret[i] = length;
        }
        return ret;
    }
    public String shortestPalindrome(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        String cs = s + "#" + rs;
        int[] pt = prefixTable(cs);
        int prefixLength = pt[pt.length - 1];
        String suffix = new StringBuilder(s.substring(prefixLength)).reverse().toString();
        return suffix + s;
    }
}
