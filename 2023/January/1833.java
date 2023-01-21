/*
 * Maximum Ice Cream Bars
 * 
 * Top 92% (15ms)
 * 
 * Due to the restriction of counting sort, the question seems like it wants you to implement some hack, but thankfully
 * the largest cost in the constraints is 100000, so its not so bad. You can be faster for cases smaller than that by
 * finding the max in the costs array first.
 * 
 * Fun fact: counting sort != bucket sort, as bucket sort generally has its buckets consist of ranges of objects,
 * which are sorted inside themselves
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] counts = new int[100001];    //10^5
        int[] sortedCosts = new int[costs.length];
        int[] prefixs = new int[costs.length];
        int bars = 0;

        for (int i = 0; i < costs.length; i++) {
            counts[costs[i]]++;
        }

        int sortedIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                for (int j = 0; j < counts[i]; j++) {
                    sortedCosts[sortedIndex] = i;
                    sortedIndex++;
                }
            }
        }

        for (int i = 0; i < sortedCosts.length; i++) {
            if (coins >= sortedCosts[i]) {
                coins -= sortedCosts[i];
                bars++;
            }
        }

        return bars;
    }
}