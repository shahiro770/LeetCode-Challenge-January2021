/*
 * Reverse Words in a String
 * 
 * Top 99% (2ms)
 * 
 * Read through the list backwards
 * 
 * Time Complexity: O(n)
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        char[] c = s.toCharArray();
        int start = c.length;
        int end = c.length;
        
        while (end > 0) {
            end--;
            if (c[end] == ' ' || end == 0) {
                if (c[end] == ' ') {
                    sb.append(s.substring(end + 1, start));
                    sb.append(' ');
                }
                else {
                    sb.append(s.substring(end, start));
                }
                while (end > 0 && c[end - 1] == ' ') {
                    end--;
                }
                start = end;
            }
        }

        return sb.toString();
    }
}