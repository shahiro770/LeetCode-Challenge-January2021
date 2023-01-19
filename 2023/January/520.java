/*
 * Detect Capital
 * 
 * Top 99% (1ms)
 * 
 * If the previous letter isn't a capital and the current one is, return false.
 * If the previous letter is a capital and the current one isn't and its not the start of a word, return false.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public boolean detectCapitalUse(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) == true && Character.isLowerCase(word.charAt(i - 1)) == true) {
                return false;
            }
            if (i >= 2 && Character.isLowerCase(word.charAt(i)) == true && Character.isUpperCase(word.charAt(i - 1)) == true && word.charAt(i - 2) != ' ') {
                return false;
            }
        }

        return true;
    }
}