/*
 * Maximum Length of Repeated Subarray
 * 
 * September 2022
 * Top 97% (80ms)
 *
 * Numbers increase in the number of bits needed to represent them by powers of 2
 *  2s      Decimal     Binary
 * 2^0      1           1
 * 2^1      2           10
 * 2^3      4           100
 * 2^3      8           1000
 * 
 * Seeing this pattern, we can determine the number of bits we need to shift the number by
 * and then add the ith value.
 * 
 * Another way of doing this is just checking if (i  & (i - 1)) == 0
 * e.g. 8 & 7 = 1000 & 0111 = 0
 *
 * Time complexity: O(n)
 */


class Solution {
    public int concatenatedBinary(int n) {
        long mod = (long)(Math.pow(10, 9) + 7);
        long ans = 0;
        int nextDouble = 1;
        int shifts = 0;
        int shiftAmount = 1;
        
        for (int i = 1; i <= n; i++) {
            ans = (long)(((ans << shiftAmount) | i) % mod);
            shifts++;
            
            if (shifts == nextDouble) {
                nextDouble *= 2;
                shifts = 0;
                shiftAmount++;
           }
        }
        
        return (int)(ans);
    }
}

/*
 1 = 1
 
 2 = 10
 3 = 11
 
 4 = 100
 5 = 101
 6 = 110
 7 = 111
 n = (n - 1) & 1
*/