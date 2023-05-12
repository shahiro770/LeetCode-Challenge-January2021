/*
 * Reverse Bits
 *
 * Top 93% (1ms)
 *
 * Take the rightmost bit of n make it the rightmost bit of reversed (Starting at 0).
 * Left shift reversed and right shift n and repeat 32 times.
 * 
 * Time Complexity: O(32)
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = reversed << 1;
            reversed = reversed | (n & 1);
            n = n >> 1;
        }

        return reversed;
    }
}