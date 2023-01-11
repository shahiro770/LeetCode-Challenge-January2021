/*
 * Domino and Tromino Tiling
 * 
 * Top 100% (0ms)
 * 
 * 
 * */

class Solution {
    public int numTilings(int n) {
        double mod = Math.pow(10, 9) + 7;
        double[] dp;
        if (n < 4) {
            dp = new double[4];
        }
        else {
            dp = new double[n + 1];
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= mod;
        }

        return (int)dp[n];
    }
}
