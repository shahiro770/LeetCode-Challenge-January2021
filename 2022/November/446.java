/**
 * Arithmetic Slices II - Subsequence
 * 
 * Top 78% (215ms)
 * 
 * Each subsequence must contain at least 3 numbers that share the same difference consecutively.
 * dp[i][d] = number of subsequences of two elements we've found that share a difference d
 * that ends at nums[i]. 
 * 
 * Time Complexity: O(n^2)
 * */

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int sol = 0;
        // using a hashmap since the range in differences far exceeds 4 billion for this
        // question's constraints, otherwise a 2d array would've been enough
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++)  {
            dp[i] = new HashMap<Long, Integer>();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                // increment the number of subsequences found that end at nums[i] by the number of
                // subsequences that end at nums[j] + 1 
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
                /*
                    Notice that its ans += cnt; if we've only found two numbers that have a diff d,
                    it won't increase the answer. However, should we find that difference again, ans will
                    go up as we would have incremented the count afterwards via the above line
                */
                ans += cnt;
            }
        }
        return sol;
    }
}