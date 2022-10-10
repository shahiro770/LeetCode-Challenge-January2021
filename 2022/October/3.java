/**
 * Longest Substring Without Repeating Characters
 * 
 * Top 98% (3ms)
 * 
 * Move the left end of your window up until it doesn't contain any duplicates, then keep going right.
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int[] vals = new int[200];  // large enough to contain all possible characters in the question (not exact)
        int left = 0;
        int right = 0;
        int longest = 0;
        while (right < c.length) {
            int val = (int)c[right];
            vals[val]++;
            if (vals[val] > 1) {
                while (vals[val] > 1) {
                    vals[(int)c[left]]--;
                    left++;
                }
                right++;
            }
            else {
                right++;
                longest = Math.max(longest, right - left);
            }
        }

        return longest;
    }
}