/*
 * Isomorphic Strings
 * 
 * Top 88% (7ms)
 * 
 * A simple letter count doesn't work here cause you must change all instances (e.g. aaabb and babab are not isomorphic).
 * Save the mapping the first time you see it, then see if the mapping changes for any following characters.
 * If the mapping does change, its not isomorphic.
 * 
 * Time Complexity: O(n);
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int map1[] = new int[200];
        int map2[] = new int[200];

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}