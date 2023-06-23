/*
 * Longest Arithmetic Subsequence
 * 
 * Top 74% (522 ms) Wow
 * 
 * The intuition here is to count the number of times a difference shows up. The most frequent difference that's seen by
 * the end of our algorithm will give us the longest subsequence. The trick here is to have an array of hashmaps, and let each index
 * count the differences its seen prior. Future indexes, if they get an identical difference to a prior index, need only take that
 * prior index's count and add one to it if the current and prior index share the same difference.
 * 
 * One edge cases: 
 * 1) We only want to count the difference once per starting index to avoid duplicates
 *  (e.g. 5,10,10,15 can only use one of the 10s to form a subsequence)
 * 
 * Time Complexity: O(n^2)
*/

class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int count = dp[j].getOrDefault(diff, 1) + 1;
                max = Math.max(max, count);
                dp[i].put(diff, count);
            }
        }

        return max;
    }
}

/*
    20,1,15,3,10,5,8

    dp[0][0] = 0;
    dp[0][1] = 1; // 19
    dp[0][2] = 1; // 5
    dp[0][3] = 1; // 17
    dp[0][4] = 2; // 10
    dp[0][5] =  ; // 15
    dp[0][6] =    // 12

    dp[1][1] = 0
    dp[1][2] = 14 
    dp[1][3] = 2
    dp[1][4] = 9
    dp[1][5] = 4
    dp[1][6] = 7

    dp[2][2] = 0
    dp[2][3] = 12
    dp[2][4] = 5
    dp[2][5] = 10
    dp[2][6] = 7

    HashMap<diff, count> = count++;

    [83,20,17,43,52,78,68,45]

*/