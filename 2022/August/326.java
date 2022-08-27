/**
 * Power of 3
 * 
 * August 2022
 * Top 62% (22ms)
 * 
 * Ran a 9ms solution and it gave me 26ms. I don't even know how you'd optimize this further
 * besides the cheeky one liner.
 */ 


class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while(n % 3 == 0 && n > 0) {
            n /= 3;
        }
        return n == 1;
    }
}