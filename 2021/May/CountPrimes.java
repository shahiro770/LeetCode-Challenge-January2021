/**
 * May 2021 Day 10
 * 
 * Beats 45.50% of solutions cause this question has 21 test cases any the "smart" kids
 * hardcoded the solutions to the larger cases to save time
 * 
 * Make a sieve of erastothones and eliminate all the compos. Some simple optimizations:
 *      1) Start at 2 (obv)
 *      2) While sieving, we only need to test up to the largest number that is less than the square root of n
 *          This is because every number larger than root n will have a root smaller than n
 *              This means all of its factors will have been tested before the root of n, so no need to test again
 *      3) When sieving out a number's multiples, start at i * i
 *          All the numbers between i and i * i will have been removed from a past sieve
 *              e.g i * 2 is composite, i * 3 is composite, i * 4 is composite...
 * 
 * Time complexity: nlgn
 */

class Solution {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        int count = 0;
            
        for (int i = 2; i * i < n; i++) {
            if (sieve[i] == true) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (sieve[i] == true) {
                count++;
            }
        }
        
        return count;
    }
}