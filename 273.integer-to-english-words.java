/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class NumberWord {
    int value;
    String word;
    
    NumberWord(int value, String word) {
        this.value = value;
        this.word = word;
    }
}

class Solution {
    List<NumberWord> list;
    public String numberToWords(int num) {
        list = new ArrayList();
        list.add(new NumberWord(1000000000, "Billion"));
        list.add(new NumberWord(1000000, "Million"));
        list.add(new NumberWord(1000, "Thousand"));
        list.add(new NumberWord(100, "Hundred"));
        list.add(new NumberWord(90, "Ninety"));
        list.add(new NumberWord(80, "Eighty"));
        list.add(new NumberWord(70, "Seventy"));
        list.add(new NumberWord(60, "Sixty"));
        list.add(new NumberWord(50, "Fifty"));
        list.add(new NumberWord(40, "Forty"));
        list.add(new NumberWord(30, "Thirty"));
        list.add(new NumberWord(20, "Twenty"));
        list.add(new NumberWord(19, "Nineteen"));
        list.add(new NumberWord(18, "Eighteen"));
        list.add(new NumberWord(17, "Seventeen"));
        list.add(new NumberWord(16, "Sixteen"));
        list.add(new NumberWord(15, "Fifteen"));
        list.add(new NumberWord(14, "Fourteen"));
        list.add(new NumberWord(13, "Thirteen"));
        list.add(new NumberWord(12, "Twelve"));
        list.add(new NumberWord(11, "Eleven"));
        list.add(new NumberWord(10, "Ten"));
        list.add(new NumberWord(9, "Nine"));
        list.add(new NumberWord(8, "Eight"));
        list.add(new NumberWord(7, "Seven"));
        list.add(new NumberWord(6, "Six"));
        list.add(new NumberWord(5, "Five"));
        list.add(new NumberWord(4, "Four"));
        list.add(new NumberWord(3, "Three"));
        list.add(new NumberWord(2, "Two"));
        list.add(new NumberWord(1, "One"));

        if (num == 0) return "Zero";
        for (NumberWord nw : list) {
            if (num >= nw.value) {
                String prefix = (num >= 100) ? numberToWords(num / nw.value) + " " : "";
                String unit = nw.word;
                String suffix = (num % nw.value == 0) ? "" : " " + numberToWords(num % nw.value);
                return prefix + unit + suffix;
            }
        }
        return "";
    }

}
// @lc code=end

