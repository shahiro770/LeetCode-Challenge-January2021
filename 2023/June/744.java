/*
 * Find Smallest Letter Greater Than Target
 * 
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }

        return letters[0];
    }
}