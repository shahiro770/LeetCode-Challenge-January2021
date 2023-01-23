/*
 * Find the Town Judge
 *
 * Top 98% (2ms)
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustTotals = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            trustTotals[trust[i][1]]++;    
            trustTotals[trust[i][0]]--;    
        }

        // only the person who everyone trusts but is trusted by no one will have their total trust = N - 1
        // due to the above +/-
        for (int i = 1; i < trustTotals.length; i++) {
            if (trustTotals[i] ==  n - 1) {
                return i;
            }
        }

        return -1;
    }
}