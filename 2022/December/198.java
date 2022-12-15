/*
 * House Robber
 * 
 * Top 100% (0ms)
 *
 * 1D DP where you either choose the current house + the best value from 2 houses back, or
 * ignore it and take the max from up to the previous house
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}

/*
HBox:    [1, 2, 3, 1]
DP:      [1, 2, 4, 4]
    On 0:
        Choose DP[-1] or DP[-2] + HBox[0]
            => DP[0] = 1
    On 1:
        Choose DP[1] or DP[0] + HBox[1]


*/