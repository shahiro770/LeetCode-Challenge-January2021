/*
 * First Unique Character in a String
 * 
 * Top 96% (6ms)
 *
 * Just do a second pass.
 *
 * Time complexity: O(n)
*/

class Solution {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        
        for (int i = 0 ; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}