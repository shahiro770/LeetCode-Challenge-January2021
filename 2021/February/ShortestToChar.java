
/**
 * Feb 2021 Day 7
 * 
 * Scan the array going right, once we find the first instance of c, mark the distance of each char from c
 * Then scan the array going left, once we find the first instance of c
 *      take the min of the prercorded right distance and the current left distance
 * Use -1 to mark if we can't determine the distance yet (due to a c not showing up in the string)
 * 
 * Time complexity: O(n) (loop once right loop a second time left)
 * 
 */

class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            if (prev != -1) {
                answer[i] = i - prev;
            }
            else {
                answer[i] = -1;
            }
        }
        
        prev = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            if (answer[i] == -1) {
                answer[i] = prev - i;
            }
            else if (prev != -1) {
                answer[i] = Math.min(prev - i, answer[i]);
            }
        }
        
        return answer;
    }
}