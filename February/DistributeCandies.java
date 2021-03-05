/**
 * March 2021 Day 1
 * 
 * You only eat half the candy types at most, so what the half value is.
 * From there, go through the candies array and map each candy value
 *      Once we've mapped as many candy types as possible, or have hit the halfway mark, return
 * 
 * O(n) time complexity
 */

class Solution {
    public int distributeCandies(int[] candyType) {
        int half = candyType.length / 2;

        HashMap<Integer, Boolean> cm = new HashMap<Integer, Boolean>();

        for (int i = 0; i < candyType.length; i++) {
           cm.put(candyType[i], true);
            if (cm.size() == half) {
                return half;
            }
        }
        return cm.size();
    }
}