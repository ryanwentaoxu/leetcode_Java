/*
 * @lc app=leetcode id=3136 lang=java
 *
 * [3136] Valid Word
 */

// @lc code=start
class Solution {
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'A') return true;
        if (c == 'e' || c == 'E') return true;
        if (c == 'i' || c == 'I') return true;
        if (c == 'o' || c == 'O') return true;
        if (c == 'u' || c == 'U') return true;
        return false;
    }
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        boolean containsVowel = false;
        boolean containsConsonant = false;
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (isVowel(c)) containsVowel = true;
            if (!isVowel(c) && !Character.isDigit(c)) containsConsonant = true;
        }
        return containsConsonant && containsVowel ? true : false;
    }
}
// @lc code=end

