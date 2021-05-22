/**
 * May 2021 Day 21
 * 
 * Top 90%
 * 
 * Map each character in the word to one in the pattern if the character in the pattern is unused.
 * You can track if a character in the pattern is being used with a boolean array for the entire alphabet.
 * If a character in the word has a mapping and is being attempted to be mapped to another character in the string
 * it can't be added to the solution
 * 
 * Time complexity: O(n), where n is the number of characters between all the words
 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> sols = new ArrayList<String>();
        char[] patternChars = pattern.toCharArray();
        boolean[] usedCharsOG = new boolean[26];
        boolean[] usedChars = new boolean[26];
        
        for (int i = 0; i < patternChars.length; i++) {
            usedCharsOG[patternChars[i] - 97] = true;
        }
        
        
        for (int i = 0; i < words.length; i++) {
            char[] wordChars = words[i].toCharArray();
            HashMap<Character, Character> wordMap = new HashMap<Character, Character>();
            boolean isSol = true;
            for (int j = 0; j < usedChars.length; j++) {
                usedChars[j] = usedCharsOG[j];
            }
            
            for (int j = 0; j < wordChars.length; j++) {
                if (wordMap.containsKey(wordChars[j]) == false && usedChars[patternChars[j] - 97] == true) {
                    wordMap.put(wordChars[j], patternChars[j]);
                    usedChars[patternChars[j] - 97] = false;
                }
                else if (wordMap.containsKey(wordChars[j]) == true && wordMap.get(wordChars[j]) != patternChars[j]) {
                    isSol = false;
                    break;
                }
                else if (wordMap.containsKey(wordChars[j]) == false && usedChars[patternChars[j] - 97] == false) {
                    isSol = false;
                    break;
                }
            }
                
            if (isSol == true) {
                sols.add(words[i]);
            }
        }
        
        return sols;
    }
}