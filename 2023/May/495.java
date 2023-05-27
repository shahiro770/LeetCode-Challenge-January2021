/*
 * Teemo Attacking
 *
 * Top 91% (2ms)
 * 
 * Leetcode was a mistake
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalTime = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            if (i > 0 && timeSeries[i] - timeSeries[i - 1] <duration) {
                totalTime += timeSeries[i] - timeSeries[i - 1];
            }
            else {
                totalTime += duration;
            }
        }  

        return totalTime;
    }
}