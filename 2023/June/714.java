/**
 * Best Time to Buy and Sell Stock with Transaction Fee
 * 
 * Top 60% (5ms)
 * 
 * Scuffed DP continues
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = prices[0] * -1;
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            /*
                Buy:
                Case 1) Hold the stock we had bought already 
                Case 2) Buy today's stock (reducing our profits, stored in sell[i - 1])
                Sell:
                Case 1) Don't sell the stock we're holding
                Case 2) Sell the stock we had on the previous day (less the fee)

                Two important consequences of doing the DP this way:
                1) Buy will always hold the cheapest stock it can find, after any profits 
                2) If there's a chain of possible sell dates, the best one dominates

                Honestly a greedy solution might work for this question.
            */
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }

        return sell[sell.length - 1];
    }
}

/*
buy = [-1, -1, -1, -1, 1, 1]
sell = [0, 0, 0, 5, 5, 8]
*/