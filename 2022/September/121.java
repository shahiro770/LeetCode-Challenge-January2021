/**
 * Best Time to Buy and Sell Stock
 * 
 * Top 36% (4ms), the top 1ms solution returns 6ms so test cases updated probably  
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // take the smallest value seen so far to maximize profit on any later days
            if (prices[i] < min) {
                min = prices[i];
            }
            else if (prices[i] > min) {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        
        return profit;
    }
}