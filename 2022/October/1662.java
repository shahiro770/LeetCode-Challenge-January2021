/*
 * Check If Two String Arrays are Equivalent
 *
 * Top 95% (1ms)
 * 
 * Time Complexity: O(n + m) where n is the length of the longest array and m is the length
 * of the concatenated strings at max length
 */

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }

        return sb1.toString().equals(sb2.toString());
    }
}