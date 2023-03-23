/*
 * Verifying an Alien Dictionary
 *
 * Top 100% (0ms) 
 * 
 * Harder end of leetcode easy.
 * 1) Build a dictionary mapping letters to their index in the alphabet
 * 2) Since a total ordering must exist in words to be lexographically ordered, all we need to do
 * is compare the word with its next word and see if those two maintain order
 *          
 * Time Complexity: O(n^2), where n is the total number of characters in all strings
 */

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alpha = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alpha[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            int minLength = Math.min(words[i].length(), words[i + 1].length());

            /**
             * For any two words, we have 3 cases:
             Case 1: There is no tie between all characters, but word 1 > word 2 at some index, 
             move to the next word
             Case 2: There is no tie between all characters, but word 2 > word 1 at some index, 
             return false
             Case 3: There is a tie between all character, but the words are different lengths,
             return false if word 2 is longer than word 1
             */
            boolean isAllTie = true;
            for (int j = 0; j < minLength; j++) {
                int char1 = alpha[words[i].charAt(j) - 'a'];
                int char2 = alpha[words[i + 1].charAt(j) - 'a'];
                if (char1 > char2) {
                    return false;
                }
                else if (char1 < char2) {
                    isAllTie = false;
                    break;
                }
            }
            if (isAllTie == true && words[i].length() > words[i + 1].length()) {
                return false;
            }
        }

        return true;
    }
}