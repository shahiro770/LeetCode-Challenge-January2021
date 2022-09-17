/**
 * Best Time to Buy and Sell Stock II
 * 
 * Top 97% (1ms)
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // lines goes up, buy
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        
        return profit;
    }
}