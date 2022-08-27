/**
 * Sqrt(x)
 * 
 * Top 100% (0ms) 
 * 
 * Failed my first submission because large numbers rolled over into negatives and timed me out with
 * an infinite loop. Need to use long, not int.
 * Time Complexity: O(lgn) because binary search
 **/

class Solution {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long mid2 = mid * mid;
            
            if (mid2 == x) {
                return (int)mid;
            }
            else if (mid2 > x) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return (int)low - 1; 
    }
}