/**
 * Power of 4
 * 
 * August 2022
 * Top 100% (1ms)
 * 
 * The billion iq way in one line solution is making note of the fact that numbers that are powers of
 * 4 have 3 properties:
 * 1) Greater than 0
 * 2) Only have one 1 bit when written in binary 
 * 3) Have their singular one bit in an odd index
 * 
 * returning num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0; would give us that solution
 * 
 * num & (num - 1) == 0 would prove there's only one 1 bit
 * 0x55555555 is hex for 1010101010101010101010101010101 (largest int with 1's in odd positions)
 */ 

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 4 == 0 ) { 
           n /= 4;
        }
        return n == 1;
    }
}