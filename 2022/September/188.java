/**
 * Best Time to Buy and Sell Stock IV
 * 
 * Top 55% (5ms)
 * 
 * Even more scuffed DP for this leetcode hard. 
 * Basically take the solution from 123.java and extrapolate for K transactions. 
 * 
 * Time complexity: O(n * k)
 */

class Solution {
    public int maxProfit(int k, int[] prices) {
        // track the most money we can have after m sells and m + 1 buys, where 0 <= m <= k + 1
        int[][] oneMoreBuyThanSell = new int[k][prices.length];
        // track the most money we can have after m + 1 sells and m + 1 buys, where 0 <= m <= k + 1
        int[][] equalBuyAndSell = new int[k][prices.length];
        int overallMaxProfit = Integer.MIN_VALUE;
            
        oneMoreBuyThanSell[0][0] = prices[0] * -1;
        // first two rows filled with min one-buy values and sell-off
        for (int i = 1; i < oneMoreBuyThanSell[0].length; i++) {
            oneMoreBuyThanSell[0][i] = Math.max(oneMoreBuyThanSell[0][i - 1], prices[i] * -1);
            equalBuyAndSell[0][i] = Math.max(equalBuyAndSell[0][i - 1], oneMoreBuyThanSell[0][i] + prices[i]); 
            overallMaxProfit = Math.max(equalBuyAndSell[0][i], overallMaxProfit);
        }

        // tabluate the rest of the values
        for (int i = 1; i < oneMoreBuyThanSell.length; i++) {
            for (int j = 0; j < oneMoreBuyThanSell[0].length; j++) {
                if (j == 0) {
                    oneMoreBuyThanSell[i][j] = equalBuyAndSell[i - 1][j] - prices[j];
                    equalBuyAndSell[i][j] = oneMoreBuyThanSell[i][j] + prices[j]; 
                }   
                else {
                    oneMoreBuyThanSell[i][j] = Math.max(oneMoreBuyThanSell[i][j - 1], equalBuyAndSell[i - 1][j] - prices[j]);  
                    equalBuyAndSell[i][j] = Math.max(equalBuyAndSell[i][j - 1], oneMoreBuyThanSell[i][j] + prices[j]); 
                }
                overallMaxProfit = Math.max(equalBuyAndSell[i][j], overallMaxProfit);
            }
        }
        
        return overallMaxProfit;
    }
}