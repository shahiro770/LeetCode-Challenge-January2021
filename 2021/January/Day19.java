/**
 * No more using the leetcode hints they lead you to the stupid solution (but I mean DP is DP)
 * How you're actually supposed to solve it:
 *      1) Go on each letter and expand outwards, if palindrome keep going, if not stop
 *      2) do this test for each odd and even length of strings at the same time
 *          E.g. if our string is ababa and we're on the second "a", we wanna test "a" and "ab" at the same time, covering expansions "bab" and "baba"
 */

class Day19 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int longStart = 0;
        int longEnd = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            start = 0;
            end = i;
            while (end < n) {
                if (start == end) {
                    dp[start][end] = 1;
                }
                else if (end - start == 1) {
                    dp[start][end] = s.charAt(start) == s.charAt(end) ? 1 : 0;
                }
                else {
                    if (s.charAt(start) == s.charAt(end)) { 
                        dp[start][end] = dp[start + 1][end - 1] == 1 ? 1 : 0;
                    }
                    else {
                        dp[start][end] = 0;
                    }
                }
                
                if (dp[start][end] == 1 && end - start > longEnd - longStart) {
                    longStart = start;
                    longEnd = end;
                }
                start++;
                end++;
            }
        }
        
        return s.substring(longStart, longEnd + 1);
    }
}