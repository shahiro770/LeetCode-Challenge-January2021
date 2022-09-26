/*
 * Maximum Length of Repeated Subarray
 * 
 * September 2022
 * Top 86% (53ms)
 *
 * 2d DP, where dp[i][j] = 1 means nums1[i] = nums2[j].
 * The catch is, if we know nums1[i - 1] = nums2[j - 1] = 1, that means 
 * the arrays matched in the previous value. 
 * Using this logic, we can say whenever there is a match, dp[i][j] = dp[i - 1][j - 1] + 1;
 *
 * Time complexity: O(n * m)
 */

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int max = 0;
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        
        return max;
    }
}