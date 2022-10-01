/**
 * Pseudo-Palindromic Paths in a Binary Tree
 * 
 * September 2022
 * Top 60% (124ms)
 *
 * Apparently simple DP but it took my mind way too long to understand.
 * you want the maximum of starting from the left or right, but you need to build
 * from the local maximum all the way on the interior to get the global max.
 * This requires memo-izing the max pick with x left choices and y right choices
 * since they will repeat states.
 * 
 * Time complexity: O(n^2), where n is the length of multpliers 
 */

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] dp = new Integer[multipliers.length][multipliers.length];
        
        return maximumScore(dp, nums, multipliers, 0, 0);
    }
    
    public int maximumScore(Integer[][] dp, int[] nums, int[] multipliers, int left, int multPos) {
        if (multPos == multipliers.length) {
            return 0;
        } 
        
        if (dp[multPos][left] != null) {
            return dp[multPos][left];
        }

        // 
        int right = (nums.length - 1) - (multPos - left);
        int rightScore = nums[right] * multipliers[multPos];
        int rightFullScore = rightScore + maximumScore(dp, nums, multipliers, left, multPos + 1);
        
        int leftScore = nums[left] * multipliers[multPos];
        int leftFullScore = leftScore + maximumScore(dp, nums, multipliers, left + 1, multPos + 1);
        
        dp[multPos][left] = Math.max(rightFullScore, leftFullScore);
        
        return dp[multPos][left];
    }
}