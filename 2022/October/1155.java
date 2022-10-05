/**
 * Decode Ways
 * 
 * October 2022
 * Top 80% (19ms)  
 * 
 * dp (2,6,7) = dp(1,6,6) + dp(1,6,5) + dp(1,6,4) + dp(1,6,3) + dp(1,6,2) + dp(1,6,1)
 *          = dp(n - 1, k, t - 1...k)) excluding the negative answers (since those go past our target)
 * dp (1,6,3) = dp(0, 6 , -3) + dp(0, 6 , -2) + dp(0, 6 , -1) +  dp(0, 6 , 0) +  dp(0, 6 , 1) + dp(0, 6 , 2)
 *          = dp(0, 6 , 0) +  dp(0, 6 , 1) + dp(0, 6 , 2)
 * 
 * Once you understand the above recurrence, dp is easy to get.
 * 
 * Time complexity: O(t * k) 
 */


class Solution {
    long mod = (long)(Math.pow(10, 9) + 7);

    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= target; j++) {
                long sum = 0;
                for (int h = 1; h <= k; h++) {
                    // we only want to use the faces of the die that don't reduce the target value
                    // below 0 (otherwise reaching the target is impossible)
                    if (j - h < 0) {
                        continue;
                    }
                    sum += dp[i - 1][j - h];
                }
                dp[i][j] = sum % mod;
            }
        }
        return (int)(dp[n][target]);
    }
}

/* 
Original Solution that got me 26% because O(tabulation) < O(memoization) 

class Solution {
    double mod = Math.pow(10, 9) + 7;

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n + 1][target + 1];
        memoize(n, k, target, dp);
    
        return dp[n][target];
    }

    public void memoize(int n, int k, int t, Integer[][] dp) {
        dp[n][t] = 0;
        if (n == 0) {
            if (t == 0) {
                dp[n][t] = 1;
            }
            else {
                dp[n][t] = 0;
            }
        }
        else {
            int bound = Math.min(k, t);
            for (int i = 1; i <= bound; i++) {
                if (dp[n - 1][t - i] == null) {
                    memoize(n - 1, k, t - i, dp);
                }
                dp[n][t] = (int)((dp[n][t] + (double)(dp[n - 1][t - i])) % mod);
            }
        }
    }
}
*/

/*
dp (2,6,7) = dp(1,6,6) + dp(1,6,5) + dp(1,6,4) + dp(1,6,3) + dp(1,6,2) + dp(1,6,1)
           = dp(n - 1, k, t -(1...k))

dp (1,6,3) = dp(0, 6 , -3) + dp(0, 6 , -2) + dp(0, 6 , -1) +  dp(0, 6 , 0) +  dp(0, 6 , 1) + dp(0, 6 , 2)
           = dp(0, 6 , 0) +  dp(0, 6 , 1) + dp(0, 6 , 2)
*/