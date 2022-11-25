/*
 * Perfect Squares
 * 
 * Top 87% (30ms)
 * 
 * Greedy doesn't work here (e.g. 12 => 3 => 2 => 1 => 0 is 4 jumps, whereas 12 => 8 => 4 => 0 is 3 jumps).
 * Starting at n, you want to see all possible jumps you can make to lower numbers,
 * and compare if there was already a faster way to reach the numbers you jumped to.
 * Repeat this process for n-1, n-2, ... 1, with the final answer being held in dp[0].
 * 
 * Time Complexity: O(n * n**(1/2)) there won't be a number who's square is smaller than n
 * past its square root.
 * */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j * j <= i; j++) {
                dp[i - j * j] = Math.min(dp[i - j * j], dp[i] + 1);
            }
        }

        return dp[0];
    }
}

/*
    21
        16
        4
        1

    12
        9   4
        1   4
        1   4
        1
    
*/