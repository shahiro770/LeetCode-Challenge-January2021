/**
 * Increasing Triplet Subsequence
 * 
 * Top 86% (7ms)
 * 
 * Get a count of the letters then grow to a window of length s1.
 * Keep track of whenever you find a character in s1 and reduce the count of the corresponding
 * character accordingly. If we reduce them all to 0 we've found the a permutation.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int[] count = new int[26];
       char[] c1 = s1.toCharArray();
       char[] c2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            count[c1[i] - 'a']++;
        }
        int left = 0;
        int right = 0;
        int len = c1.length;    // if this = 0, we have all letters in s1 accounted for
        while (right < c2.length) {
            // if the letter found was in s1, reduce the count
            if (count[c2[right] - 'a'] >= 1) {
                len--;
            }
            count[c2[right] - 'a']--;
            right++;
            if (len == 0) {
                return true;
            }
            //if we've passed the max window length we will need to shrink the left
            if (right - left == c1.length)  {
                // if the count is >= 0 ,that means the letter we are removing was a part of s1
                // letters that are not a part of s1 will be below 0 as they are decremented
                // whenever one is found
                if (count[c2[left] - 'a'] >= 0) {
                    len++;
                }
                count[c2[left] - 'a']++;
                left++;
            }
        }
        return false;
    }

}