/**
 * Minimum Window Substring
 * 
 * Top 92% (5ms)
 * 
 * Similar to 567.  The catch here is that you have no max window until you find all characters
 * in the target string t. In other words, you only move up your left once you've found a window,
 * shirnking it to the minimum possible. After that move your window up by 1 character and repeat the process to search
 * for a new one. The minimum window will be the shortest of all candidates.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public String minWindow(String s, String t) {
        String minWindow = "";
        if (s.length() < t.length()) {
            return minWindow;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] count = new int[200];
        for (int i = 0; i < t.length(); i++) {
            count[ct[i]]++;
        }    
        int left = 0;
        int right = 0;
        int len = ct.length;

        while (right < cs.length) {
            if (count[cs[right]] >= 1) {
                len--;
            }
            count[cs[right]]--;
            right++;
            if (len == 0) {
                while (len == 0) {
                    count[cs[left]]++;
                    // only character counts for t can possibly have a count greater than 0
                    if (count[cs[left]] >= 1) {
                        String newWindow = s.substring(left, right);
                        if (newWindow.length() < minWindow.length() || minWindow.equals("")) {
                            minWindow = newWindow;
                        }
                        len++;
                    }
                    left++;
                }
            }
           
        }
        return minWindow;
    }
}