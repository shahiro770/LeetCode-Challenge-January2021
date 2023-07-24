/*
 * Pow (x, n)
 *
 * Top 100% (0ms)
 * 
 * Trick here to compute this quickly is realizing that X^2n = (X^2)^ n
 * With this we can just divide th epower in half each time as we multiply.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // flip from negative to positive exponent
        if (n < 0) {
            return 1 / x * myPow(1 / x, (n + 1) * -1);
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}