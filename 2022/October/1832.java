/**
 * Check if the Sentence Is Pangram
 * 
 * Top 100% (0ms)
 * 
 * Python could do this in one line i'd bet.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public boolean checkIfPangram(String sentence) {
        int count = 0;
        int[] vals = new int[26];
        char[] c = sentence.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (vals[c[i] - 'a'] == 0) {
                vals[c[i] - 'a']++;
                count++;
            }
            if (count == 26) {
                return true;
            }
        }
        return false;
    }
}