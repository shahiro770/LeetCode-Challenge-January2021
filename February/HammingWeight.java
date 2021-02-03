/**
 * Feb 2021 Day 1
 * 
 * Just bit shift it to the right while tracking the right most bit
 * Or use Integer.countBits
 * Time complexity is O(1)
 */

public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}