/*
 * Excel Sheet Column Number
 *
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int titleToNumber(String columnTitle) {
        int col = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            col *= 26;
            col += columnTitle.charAt(i) - 'A' + 1;
        }

        return col;
    }
}