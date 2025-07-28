/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();
        Set<Character> seen = new HashSet();
        Map<Character, Integer> last_occurence = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            last_occurence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && last_occurence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}
// @lc code=end

