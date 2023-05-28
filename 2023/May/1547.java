/*
 * Minimum Cost to Cut a Stick
 *
 * Top 80% (12ms)
 * 
 * This one I just barely understand.
 * 
 * Using the given example, we have stick length of n = 7, and 4 cuts to make [1, 3, 4, 5].
 *      What we want is the total cost of all cuts 
 *          If we view the problem as "rejoining" sticks instead,
 *              we could say we want the total cost to fuse points 0 and 7 together to form a stick of length 7.
 *      Add positions 0 and 7 to the joins array to make it easier to logic
 *          Sort the array of joins as well to keep our sticks in order
 *              dp[0][6] will be our final answer
 *      Now we have sticks [0, 1], [1, 3], [3, 4], [4, 5] and [5, 7]
 * 
 * Iterate through the joins array from the end (descending) as the larger/more costly "rejoin" operations will be from the start
 *     For every pair of fuses , we want to choose the one that's least costly
 *          The first pair that comes up is [5,7]
 *              The cost to fuse [5,7] is 0, since we are starting with this piece
 *          The next pair is [4,5]
 *              The cost to fuse [4,5] is 0, since we are starting with this piece
 *          The next pair is cost to fuse [4,7]
 *              Cost is 3, [5,7] is length 2, [4,5] is length 1, and we have no cheaper option at this stage
 *          [3,4]
 *              Cost is 0, starting piece
 *          [3,5]
 *              Cost is 2, [3,4] and [4,5] are both starting pieces of length 1
 *          [3,7]
 *              The minimum cost to rejoin these pieces is 4 (since 7 - 3 is 4)
 *                  But what is the min cost to join the pieces involved? ([3,4], [4,5], and [5,7])
 *                      Cheapest cost to fuse [4,5] with [5,7] is 3
 *                      Cheapest cost to fuse [3,4] and [4,5] is 2
 *                          If we fuse [4,5] to [5,7] (cost 3) and then fuse [3,4] to [4, 7] (cost 4), the overall cost is 7
 *                          However, if we fuse [3,4] to [4,5] first (cost 2), and then fuse [3,5] to [5,7] (cost 4), the ovearll cost is 6
 *                              By iterating through the possible piece combinations inbetween, we will arrive at similar optimizations for all pieces
 * 
 * Time Complexity: O(n^3 + nlgn)
 */

class Solution {
    public int minCost(int n, int[] cuts) {
        int[] joins = new int[cuts.length + 2];
        int[][] dp = new int[joins.length][joins.length];
        joins[0] = 0;
        joins[1] = n;
        for (int i = 0; i < cuts.length; i++) {
            joins[i + 2] = cuts[i];
        }
        Arrays.sort(joins);

        // try every pair of cut, going from the end
        // + 1s are important, otherwise we'd be testing dp[i][i] which doesn't make sense
        for (int i = joins.length - 1; i >= 0; i--) {   // i is the starting index
            for (int j = i + 1; j < joins.length; j++) {    // j is the ending index
                // k represents the "joining" cut, the cost of dp[i][j] will be the cheapest cut performed before k + the cheapest cut 
                // performed after k
                for (int k = i + 1; k < j; k++) {
                    if (dp[i][j] == 0) {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                    dp[i][j] = Math.min(dp[i][j],
                    joins[j] - joins[i] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][joins.length - 1];
    }

    /* 
    public int dfs(int[] cuts, Integer[][] dp, int start, int end) {
        if (end - start <= 1) {
            return 0;
        }

        if (dp[start][end] == null) {
            // System.out.println(start + " " + end);
            dp[start][end] = Integer.MAX_VALUE;
            for (int i = start + 1; i < end; i++) {
                // System.out.println("Attemping to cut: " + cuts[i]);
                dp[start][end] = Math.min(dp[start][end],
                cuts[end] - cuts[start] + dfs(cuts, dp, start, i) + dfs(cuts, dp, i, end));
            }
            // System.out.println(cuts[start] + " " + cuts[end] + ": " + dp[start][end]);
        }
        return dp[start][end];
    }
    */
}