/*
 * Reverse Integer
 *
 * Top 100% (1ms)
 * 
 * Time Complexity: O(n) where n is the number of digits in x
 */

class Solution {
    public int reverse(int x) {
        long reverse = 0;
        boolean isNegative = x < 0 ? true : false;

        while (Math.abs(x) > 0) {
            int rightDigit = Math.abs(x) % 10;
            reverse += rightDigit;
            x /= 10;
            if (Math.abs(x) > 0) {
                reverse *= 10;
            }
        }

        if (isNegative) {
            reverse *= -1;
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)reverse;
    }
}