/**
 * Count Vowels Permutation
 * Aug 2022 Day 7
 * Top 100% (0ms)
 * 
 * DP question. Draw a directed graph showing which vowels can be written after a given vowel.
 * Notice how the number of strings that can be formed that end in a given vowel will always
 * be the result of the number of strings that end in a vowel that can lead to the given vowel.
 * Mod after every step to avoid overlow.
 * 
 * Time complexity: O(), where t is the target and n is the number of elements
 */

class Solution {
    
    public int countVowelPermutation(int n) {
        double ans = 0;
        
        double [][] dp = new double[n][5];
        double mod = (Math.pow(10, 9) + 7);
        
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][3] = (dp[i - 1][2]) % mod;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n - 1][i]) % mod;
        }
        
        return (int)ans;
    }
}