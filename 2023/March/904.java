/*
 * Fruit Into Baskets
 *
 * Top 93% (6ms)
 * 
 * This is barely a sliding window question but whatever I guess. Used lee215's solution for help because
 * he breaks the logic down very cleanly. In short, encountering a fruit "x" not in the basket while you already have two fruit types means you need to drop all 
 * fruit before the longest chain of fruit up until x. E.g.
 * 
 * zyzyyyx
 * 
 * We need to get rid of all "z" fruit, but in doing so, we can't keep the first y fruit either. Only fruit we can
 * actually keep are all the y's prior to the x. Notice in the code below how the counting of fruit is seperate
 * from the chain tracking, due to the case where the chain breaks but the fruit involved are the same . E.g.
 * 
 * zzyyzzyy
 * 
 * longestChain = 2, but currFruitCount = 8
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int totalFruit(int[] fruits) {
        int fruitA = -1;    // most recent fruit type added to basket (note: this could be fruitB)
        int fruitB = -1;    // second most recent fruit type added to basket
        int lastLongestChain = 0;   // longest continuous subsequence prior to a new fruit being put in the basket
        int currMax = 0;
        int max = 0;

        for (int i = 0; i < fruits.length; i++) {
            // if the fruit type is in the basket, increase the fruit count
            if (fruits[i] == fruitA || fruits[i] == fruitB) {
                currMax++;
            }
            // if the fruit type isn't in the basket, the fruit count "resets" to the previous longest chain 
            // + the new fruit type
            else {
                currMax = lastLongestChain + 1;
            }

            // add to the chain if its another consecutively same fruit
            if (fruits[i] == fruitA) {
                lastLongestChain++;
            }
            // otherwise the chain resets
            // fruitB to track of the type of the old chain
            // fruitA to tracck the type of the new chain
            else {
                lastLongestChain = 1;
                fruitB = fruitA;
                fruitA = fruits[i];
            }

            max = Math.max(max, currMax);
        }
        
        return max;
    }
}