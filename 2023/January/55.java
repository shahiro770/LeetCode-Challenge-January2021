/*
 * Jump Game
 *
 * Top 82% (2ms) (Leetcode won't even show a 1ms solution???)
 * 
 * Easiest DP of all time. From each square you record the maximum lookahead and visited squares
 * in that lookahead. If you find anything that exceeds the current lookahead, update it and continue
 * until you either reach the end or run out of squares to check.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        // edge case, with [0] you are still at the end
        if (nums.length == 1) { 
            return true;
        }

        for (int i = 1; i <= max; i++) {
            max = Math.max(max, nums[i] + i);

            if (max >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}