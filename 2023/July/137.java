/**
 * Single Number II
 *
 * Top 100% (0ms)
 * 
 * Took me a while to understand why this solution works. The trick is to realize that there is the bits are basically being counted.
 * Every number that appears 3 times will add 3 to the total number of bits at the respective indices. What we're looking for is
 * the remainder of bitCount % 3 as the singular number will have its bits only show up once (i.e. for some bits, the count will be 3n + 1
 * which % 3 = 1).
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            /*
                1) First time number shows up save it in ones
                2) Second time number shows up move it from ones to twos
                3) Third time number shows up, clear it from twos
                4) The single number will be the only be in ones
            */
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }
}