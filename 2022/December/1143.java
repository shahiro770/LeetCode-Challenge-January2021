/*
 * Longest Common Subsequence
 * 
 * Top 99% (5ms)
 *
 * Iconic 2D DP.
 * 
 * For any pair of indices i, j and strings A,B where:
 *      A[i] = the i-th char of a
 *      B[j] = the j-th char of b
 * If we see A[i] == B[j], we can record  dp[i + 1][j + 1] = dp[i][j] + 1
 *      That is, using up to i characters from A, and j characters from B, dp[i][j] + 1
 *      of them match in the same order (i.e. a subsequence)
 * If we don't see there being a match, dp[i + 1][j + 1] = max(dp[i + 1][j], dp[i][j + 1])
 *      If we were to take i characters from A, and j characters from B
 *      whatever was the largest subsequence up until now will either be recorded either in
 *          1) Taking i characters from A and j - 1 characters from B
 *          2) Taking i - 1 chararacters from B and j characters from B
 *      Both are the largest possible quantities of characters taken prior to i + j, but
 *      we can't assume (i, j - 1) gave us a larger subsequence than (i - 1, j) 
 *          Due to the nature of iteration, both of these combos will be visited prior to (i, j)
 * Notice that we are storing the result the next spot in the dp array (the +1s)
 *      Makes indexing easier, as it does in a lot of dp problems
 *   
 * Why does this logic work?
 *      Lets look at the example A = "abcadcab" and B = "dcab" and some of the results in dp
 *          dp[1][1] = 0
 *              Using the first character from either string does not give us anything in common
 *          dp[1][3] = 1
 *              There's a single 'a' towards the end of B. We could start a subsequence there,
 *              though we only have 'a' to work with from A
 *          dp[1][4] = 1
 *              No change from dp[1][3] with another character
 *          dp[3][4] = 1
 *              There are three ways to get a subsequence of length 1 with "abc" and "dcab",
 *              A[0] = B[2], A[1] = B[3], A[2] = B[1]
 *                  But these pairs are not in order 
 *                      Should be able to rearrange them such that the indices are montonically increasing
 *          dp[4][4] = 2
 *              There's a contiguous match "ca"
 *                 After the 'c' match (A[2] = B[1]), any match that happens after for i > 2 and j > 1
 *                 has to be using characters after the 'c'
 *          dp[7][4] = 2
 *              There's a "ca" again, but notice it doesn't matter which "ca" we take
 *          dp[9][4] = 3
 *              Final match on the last 'b's gives us a longest subsequence of 3
 * 
 * I know it can be memory optimized to two rows, but it makes the solution less intuitive to look at.
 * 
 * Time Complexity: O(n * m)
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][ j + 1] = c1[i] == c2[j] ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        
        return dp[m][n];
    }
}