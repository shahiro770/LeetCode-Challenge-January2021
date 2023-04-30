/*
 * Length of Last Word
 * 
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = 0;
        int index = s.length() - 1;
        while (index > -1 && s.charAt(index) != ' ') {
            length++;
            index--;
        }
        return length;
    }
}