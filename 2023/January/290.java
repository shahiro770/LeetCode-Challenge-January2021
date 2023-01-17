/*
 * Word Pattern
 * 
 * Top 90% (1ms)
 * 
 * Surprisingly tricky leetcode easy. You need to check the mapping exists both ways, otherwise cases such try and re-use
 * a mapping with a different letter will end you.
 * 
 * Time Complexity: O(n^2)
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map = new HashMap<String, Character>();
        HashMap<Character, String> map2 = new HashMap<Character, String>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            String w = words[i];
            char c = pattern.charAt(i);

            if (map.containsKey(w) 
            && (map2.containsKey(c) == false || map2.get(c).equals(w) == false)) {
                return false;
            }
            else if (map2.containsKey(c) 
            && (map.containsKey(w) == false || map.get(w) != c)) {
                return false;
            }
            else {
                map.put(w, c);
                map2.put(c, w);
            }
        }

        return true;
    }
}