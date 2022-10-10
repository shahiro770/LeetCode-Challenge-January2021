/**
 * Best Time to Buy and Sell Stock
 * 
 * Top 75% (3ms)
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            right++;
        }

        return maxProfit;
    }
}