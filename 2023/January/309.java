/*
 * Best Time to Buy and Sell Stock with Cooldown
 * 
 * Top 76% (1ms)
 * 
 * Draw out the state machine then logic through what the values for the current day will be based on the possible
 * transitions from the previous day. Only trick is to realize that buying in the dp[][] can be represented as subtracting
 * the current stock's value from the value in a given index (and adding while selling).
 * 
 * Time Complexity: O(n)
 *
 * */

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        /*
            For each day, there are 3 possible states:
            0) We aren't holding a stock
                From here we can either buy a stock (1), or not do anything (0)
            1) We are holding a stock
                From here we can sell the stock (2) or not do anything (1)
            2) We are in cooldown
                From here we can't do anything (0)

            From the above logic, we can reason the transitions from the different states:
            
            0, 2 -> 0
            0, 1 -> 1
            1 -> 2
        */

        /*
         * Base case values for day 0 using the above logic:
         * [0] = 0 as it would be impossible to sell a stock on day 0
         * [1] = Buy the stock on day 0
         * [2] = Set this to the minimum value, just so Math.max() gets it overriden by the first sell that occurs
         */
        dp[0][0] = 0;   
        dp[0][1] = prices[0] * -1;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]); 
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        // answer will either be the highest value from when we aren't holding any stock, or while we're on cooldown from selling
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}