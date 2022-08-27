/*
 * Unique Morse Code Words
 * August 2022
 * 
 * Top 99% (2ms)
 *
 * Time complexity: O(n) where n is the number of characters
*/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseTable = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashMap<String, Integer> morseWords = new HashMap<String, Integer>();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(morseTable[words[i].charAt(j) - 'a']);
            }
            morseWords.put(sb.toString(), 0);
        }
        
        return morseWords.entrySet().size();
    }
}