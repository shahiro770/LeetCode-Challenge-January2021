/*
 * Maximum Bags With Full Capacity of Rocks
 *
 * Top 98% (14ms) 
 * 
 * Greed is good. Figure out the number of rocks each bag can take and sort that in ascending order.
 * Use your additional rocks on smallest demanding bags first and repeat until you run out of rocks.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] fill = new int[rocks.length];

        for (int i = 0; i < rocks.length; i++) {
            fill[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(fill);
        int sol = 0;

        for (int i = 0; i < fill.length; i++) {
            if (additionalRocks >= fill[i]) {
                additionalRocks -= fill[i];
                sol++;
            }
            else {
                break;
            }
        }

        return sol;
    }
}