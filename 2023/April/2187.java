/*
 * Minimum Time to Complete Trips
 * 
 * Top 66% (204ms)
 * 
 * First binary search I've done where the hard part was figuring out what low and high had to be.
 * 
 * Time Complexity: O(nlgn) 
 */

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long high = Long.MAX_VALUE;
        for (int i = 0; i < time.length; i++) {
            if (time[i] < high) {
                high = time[i];
            }
        }
        high *= totalTrips;
        long mid = 0;
        long sol = high;

        while (low <= high) {
            mid = low + (high - low) / 2;

            long trips = 0;
            for (int i = 0; i < time.length; i++) {
                trips += mid / time[i];
            }
            if (trips < totalTrips) {
                low = mid + 1;
            }
            else {
                if (mid < sol) {
                    sol = mid;
                }
                high = mid - 1;
            }
        }

        return sol;
    }
}