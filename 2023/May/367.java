/*
 * Valid Perfect Square
 *
 *
 * Top 100% (0ms)
 * 
 * Time Complexity: O(lgn)
 */

class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num / 2 + 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sqr = mid * mid;
            if (sqr == num) {
                return true;
            }
            else if (sqr > num) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return false;
    }
}