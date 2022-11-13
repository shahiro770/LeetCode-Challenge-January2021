/*
 * Koko Eating Bananas
 * 
 * Top 54% (47ms) 
 * 
 * The amount of bananas koko needs to eat to maximize the hours taken (obviously we want a healthy
 * digestion) is what needs to be binary searched. This will be a number between 1 and the 
 * max number of bananas in a pile (we have the constraint h >= piles.length).
 * 
 * Take the mid point of these numbers, if we manage to get at or under the hour threshold, see if we can
 * eat less banans per hour by setting high = mid - 1. Otherwise up the low because we missed the threshold.
 * 
 * Time Complexity: O(lgn * n)
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
    
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        int res = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += Math.ceil((double)piles[i] / mid); // truncation due to integers messes ceil up so double typecast is a must
            }
            if (hours <= h) {
                res = Math.min(res, mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return res;
    }
}
/*
pile = [3,6,7,11] h = 8

low     high        mid         h       decision
1       11          6           6       high = mid
1       6           3           10      low = mid 
3       6           4           8

piles = [30,11,23,4,20], h = 6

low     high        mid         h   decision
1       30          15          8   low = mid = 15
15      30          22          7   low = mid = 22
22      30          26          6   high = mid = 26
22      26          24          6   high = mid = 24
22      24          23          6   high = mid = 23
22      23          22          7   Stop
*/