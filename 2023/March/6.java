/*
 * Zigzag Conversion
 *
 * Top 74% (5ms) 
 * 
 * If its under 100, prepare for jank and 1000 test cases.
 * 
 * The horizontal movement of the zigzag can be "ignored" by appending to an array of strings, going up and
 * down on said strings. Finally append the strings from top to bottom for the final answer.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        int sPos = 0;
        int sbPos = 0;
        int dir = 1;
        while (sPos < s.length()) {
            sbs[sbPos].append(s.charAt(sPos));
            sPos++;
            sbPos += dir;
            if (sbPos == numRows - 1|| sbPos == 0) {
                dir = dir * -1;
            }
            
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
            sb.append(sbs[i].toString());
        }

        return sb.toString();
    }
}