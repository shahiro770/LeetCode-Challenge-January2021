/*
 * Power of Two
 *
 * Top 91% (2ms
 * 
 * Time Complexity: O(lgn)
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if ((n & 1) == 1) {
                return false;
            }
            n >>= 1;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}