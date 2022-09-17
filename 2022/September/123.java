/**
 * Best Time to Buy and Sell Stock III
 * 
 * Top 97% (3ms)
 * 
 * This is like scuffed DP.
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = Integer.MIN_VALUE;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = Integer.MIN_VALUE;
            
        for (int i = 0; i < prices.length; i++) {
            // money we have at most after one purchase
            oneBuy = Math.max(oneBuy, prices[i] * -1);  
            // max money we can have after buying once and selling once
            oneBuyOneSell = Math.max(oneBuyOneSell, oneBuy + prices[i]);
            // max money we can have after buying once and selling once, and then buying again
            // i.e. both times we bought we bought the stock at its lowest
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);
            // max money we can have after selling both of our bought stocks
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices[i]);
        }
        
        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
}