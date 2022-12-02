/**
 * Unique Number of Occurrences
 * 
 * Top 94% (3ms)
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public boolean halvesAreAlike(String s) {
        int count1 = 0;
        int count2 = 0;
        s = s.toLowerCase();

        for (int i = 0; i < s.length() / 2; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count1++;
            } 
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count2++;
            } 
        }

        return count1 == count2;
    }
}