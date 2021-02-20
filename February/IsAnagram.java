/**
 * Feb 2021 Day 11
 * 
 * Top 95%
 * If it were all unicode characters you'd need to use a hashmap probably (but performance will take a hit)
 * Only big optimization is using char: s.toCharArray(), which is infinitely faster than charAt()
 * O(n) cause we got 2 loops of the same length
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charArr = new int[26];   // number of characters in alphabet
        if (s.length() != t.length()) {
            return false;
        }

        for (char c: s.toCharArray()) {
            charArr[c - 'a']++;
        }

        for (char c: t.toCharArray()) {
            charArr[c - 'a']--;
            
            if (charArr[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}