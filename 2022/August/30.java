/*
 * Substring with Concatenation of All Words
 * 
 * Top 63% (149ms)
 * 
 * This is sort of a brute force solution below. I reset the hashmap every time 
 * I see a word that is illegal or goes over the count.
 * You can much more intelligently slide the window up by a single word in the event you've run into
 * the case where a word goes over the count by removing the words from the hashmap to avoid double counting
 * but it was too much work.
 *
 * Time complexity: O(n * b) where n is the string length and b is the number of words to be checked
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        
        int wordLength = words[0].length();
        int wordsLength = wordLength * words.length;
        for (int i = 0; i < words.length; i++) {
            countMap.put(words[i], countMap.getOrDefault(words[i], 0) + 1);
        }
        
        List<Integer> indices = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length() && i + wordsLength <= s.length(); i++) {
            HashMap<String, Integer> seenMap = new HashMap<String, Integer>();
            boolean fullMatch = true;
            
            for (int j = i; j < i + wordsLength; j += wordLength) {
                String sub = s.substring(j, j + wordLength);
                if (countMap.containsKey(sub)) {
                    seenMap.put(sub, seenMap.getOrDefault(sub, 0) + 1);
                    if (seenMap.get(sub) > countMap.get(sub)) {
                        fullMatch = false;
                        break;
                    }
                }
                else {
                    fullMatch = false;
                    break;
                }
            }
            
            if (fullMatch == true) {
                for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                    if (seenMap.containsKey(entry.getKey()) == false ||
                       (int)seenMap.get(entry.getKey()) != (int)entry.getValue()) { 
                        fullMatch = false;
                        break;
                    }
                }
            }
            
            if (fullMatch == true) {
                indices.add(i);
            }
        }
      
        return indices;
    }
}