/*
 * Ugly Number
 * 
 * Top 80% (2ms)
 * 
 * 0 has an infinite number of prime factors, therefore it is never ugly.
 * By definition, -1 is not prime, therefore even if you could factor out a bunch of 2s, 3s, and 5s,
 * it can't be reduced to 1 with only those prime factors.
 * 
 * Time complexity: O(idk)
 * */

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}