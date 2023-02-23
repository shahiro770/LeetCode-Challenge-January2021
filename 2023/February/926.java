/**
 * Flip String to Monotone Increasing
 *
 * Top 96% (8ms)
 * 
 * One of those dp problems that is tricky to comprehend since it doesn't really need an array. You got two cases when you look
 * at a new digit:
 * Case 1: If it's a 1, assume we would have to flip it to a 0 to maintain monotonicity
 * Case 2: If it's a 0, either we would have to flip all previous 1's to zeroes to maintaing monotonicity,
 *         or flip it to a 1 immediately
 * 
 * How we handle these cases:
 * Case 1:
 *      Increment a count of the number of 1's we've seen so far. This is NOT the final answer, as if we get a string like
 *      01111, there would be no need to do any flipping.
 * Case 2:
 *      Update the answer to the smaller of the number of 1's we've seen (counted through case 1), and
 *      the current ans + 1.
 *          ans + 1 represents flipping the newly appended 0 to a 1, while maintaining all previous flips
 *              Suppose we had 110001100
 *                  At index 4, we would set ans = 2 as we would flip all the 1s to 0s.
 *                  At index 7, we would set ans = 3, flipping the latest 0 and mainintaing the previous flips
 *                  At index 8, we would set ans = 4, flipping the latest 0 and maintaining the previous flips
 *          Don't make the mistake of thinking it means to flip ALL of the previous 1s to 0s
 *
 * Time Complexity: O(n)
 */

class Solution {
    public int minFlipsMonoIncr(String s) {
        int numFlips = 0;
        int ans = 0;
        char[] cs = s.toCharArray();
    
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') {
                numFlips++;
            }
            else {
                ans = Math.min(numFlips, ans + 1);
            }
        }

        return ans;
    }
}

