/**
 * Valid Anagram
 *
 * October 2022
 * Top 99% (2ms)  
 * 
 * Count the letters
 * 
 * Time complexity: O(n)
 * */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] l1 = new int[26];
        int[] l2 = new int[26];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        for (int i = 0; i < sa.length; i++) {
            l1[sa[i] - 'a']++;
            l2[ta[i] - 'a']++;
        }
        for (int i = 0; i < l1.length; i++) {
            if (l1[i] != l2[i]) {
                return false;
            }
        }

        return true;
    }
}