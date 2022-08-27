/**
 * Longest Increasing Subsequence
 * Aug 2022 Day 8
 * Top 65% (65ms)
 * 
 * 1-D DP days. There's an nlogn solution using binary search that's a little more complex to achieve.
 * Read this: https://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn
 *
 * Time complexity: O(n^2)
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        LIS[nums.length - 1] = 1;
        int longest = LIS[nums.length - 1];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int largestLIS = LIS[nums.length - 1];
            for (int j = i + 1; j < nums.length; j++) {
                /*
                 * If an element could possibly be part of any of the subsequences that came
                 * before it, then "add it" to all the longest subsequences possible at each position.
                 * The longest of all these subsequences will be the longest subsequence from the
                 * current index
                 */
                if (nums[i] < nums[j]) {   
                    largestLIS = Math.max(largestLIS, LIS[j] + 1);
                }
            }
            LIS[i] = largestLIS;
            if (LIS[i] > longest) {
                longest = LIS[i];
            }
        }
        
        return longest;
    }
}
