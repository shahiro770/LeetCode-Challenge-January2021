/*
 * Climbing Stairs
 * 
 * Top 100% (0ms)
 *
 * There's 1 way to get to step 1. And 2 ways to get to step 2. For any step after those two
 * since you can either take 1 or 2 steps, step[n] = step[n - 1] + step[n - 2].
 * 
 * The problem is effectively fibonacci.
 *
 * Time Complexity: O(n)
 */

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}