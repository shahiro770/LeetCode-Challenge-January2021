/**
 * Reverse Words in a String III
 * 
 * September 2022
 * Top 73% (8ms)
 * 
 * Time complexity: O(n)
 */

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        int startPos = 0;
        int endPos = 0;
        int stringEnd = s.length();
        
        while (endPos != stringEnd) {
            
            if (s.charAt(endPos) != ' ') {
                endPos++;
            }
            else {
                sb.append(reverseSubstring(s, startPos, endPos - 1));
                
                while(s.charAt(endPos) == ' ') {
                    sb.append(' ');
                    endPos++;
                }
                startPos = endPos;
            }
        }
        sb.append(reverseSubstring(s, startPos, endPos - 1));
        
        return sb.toString();
    }
    
    public String reverseSubstring(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= start; i--) {
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}