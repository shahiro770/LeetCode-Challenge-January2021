/*
 * Domino and Tromino Tiling
 * 
 * Top 100% (0ms)
 * 
 * Not going to try and explain this one as you need to draw out the possible combos to deduce the recurrence relation.
 * This leetcode explanation makes the most sense, but rip getting an interview with this question.
 * https://leetcode.com/problems/domino-and-tromino-tiling/solutions/116581/detail-and-explanation-of-o-n-solution-why-dp-n-2-d-n-1-dp-n-3/
 * 
 * Read the top comment to understand the logic further (subtracting the formulas
 * for dp[n] and dp[n - 1] is a billion iq). I am not smart enough to figure this one out on my own.
 * 
 * Time Complexity: O(n)
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

        // base cases
        dp[1] = 1;  // 1 way to  tile 2 x 1
        dp[2] = 2;  // 2 ways to tile 2 x 2
        dp[3] = 5;  // 5 ways to tile 2 x 3

        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= mod;
        }

        return (int)dp[n];
    }
}
