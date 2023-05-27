/*
 * Stone Game II
 *
 * Top 100% (3ms)
 * 
 * Tricky DP question to follow.
 * 
 * Time Complexity: O(n^2)
 */

class Solution {
    public int stoneGameII(int[] piles) {
        /*
         * SuffixSum[i] = how many points are left in the game from this pile onwards
         */
        int[] suffixSum =  new int[piles.length];
        /*
         * DP[i][j] = from position i and j = m lookahead, the max number of points obtainable
         */
        int[][] dp = new int[piles.length][piles.length];
        suffixSum[suffixSum.length - 1] = piles[piles.length - 1];

        for (int i = suffixSum.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return helper(piles, suffixSum, dp, 0, 1);
    }

    private int helper(int[] piles, int[] suffixSum, int[][] dp, int pos, int m) {
        // no piles left, base case
        if (pos == piles.length) {
            return 0;
        }
        // the last player takes all piles if possible
        if (pos + 2 * m >= piles.length) { 
            dp[pos][m] = suffixSum[pos];    // this pointless to do but it helps me think about the problem
            return suffixSum[pos];
        }

        // if we know the optimal play from the current position, return
        // the number of points that would be gotten
        if (dp[pos][m] != 0) {
            return dp[pos][m];
        }

        /*
         * For each possible pile section from the current position (i.e. taking at most 2 *m piles),
         * we want to record the max points obtainable, building the solution back up as we
         * find out the max points obtainable from later positions (hence the recursion)
         */
        int sol = 0;    // sol is the current highest
        for (int i = 1; i <= 2 * m; i++) {
            /*
             * Since each player is playing optimally, we will only be able to obtain 
             * suffixSum[pos] - the best play from position pos + i as thats how many points the other player will take
             */
            sol = Math.max( 
                sol, 
                suffixSum[pos] - helper(piles, suffixSum, dp, pos + i, Math.max(m, i)));
        }
        
        dp[pos][m] = sol;
        return sol;
    }
}