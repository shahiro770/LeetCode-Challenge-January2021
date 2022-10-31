/*
 * Minimum Difficulty of a Job Schedule
 * 
 * 2d dp hurts my brain. Bottom up because top down hurts my brain more here.
 * 
 * Time Complexity: O(d * n * n)
 */

class Solution {
    public int minDifficulty(int[] jd, int d) {
        int numJobs = jd.length;
        if (d > jd.length) {
            return -1;
        }
        int[][] dp = new int[d][numJobs];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        /*  
            We must have at least one job per day. E.g.
            6 jobs
            3 days
            Day 1 can only do 4 jobs at most
        */
        int minWork = 0;
        for (int i = 0; i <= numJobs - d; i++) {
            minWork =  Math.max(minWork, jd[i]);
            dp[0][i] = minWork;
        }

        for (int i = 1; i < dp.length; i++) {
            /*
                For each day after the first, we can assume at least i jobs were completed up to the current day e.g.
                6 jobs
                3 days
                On day 1 we can do at most 4 jobs
                On day 2, we can do at most 4 jobs
                On day 3, we can do at most 4 jobs
                So we have a + i to shift our "most jobs" range up
            */
            for (int j = i; j <= numJobs - d + i; j++) {
                int currentDayDifficulty = jd[j];
                minWork = Integer.MAX_VALUE;
                /* 
                 * To keep the dp array 2d, j only represents "what if we took j jobs up until this point?"
                 * This means it says nothing about if we took half of the j jobs over the last i days,
                 * or if we took the minumum 1 job per day over the last i days and then j - i jobs today.
                 * 
                 * As an easier way to explain why, suppose we had 4 jobs (1,2,3,4) and 2 days. For simplicity
                 * assume the work = the job number
                 * 
                 * On day 1, we either take 1 or 1,2 or 1,2,3
                 * On day 2 if the last job taken was:
                 *      1 -> we need to try accepting 2 or 2,3 or 2,3,4
                 *      2 -> we need to try accepting 3 or 3,4
                 *      3 -> we need to try accepting 4
                 * 
                 * This means we have two logical branches:
                 * 1) Suppose we accepted the jth job today and the rest of the k jobs up until now were
                 * accepted in the past. The total difficulty of the schedule  
                 * will be jobs[j] + workAlreadyDone[up until i - 1][j - 1 jobs accepted] 
                 * 
                 * 2) Suppose instead the jth job was done today, as well as the j - 1,2...nth job.
                 * We'll need to now know the difficulty of the current day, as well as the difficulty
                 * of the past assuming we only did up to j - 1,2,...n jobs in the past.
                 * The new formula for total difficulty will be 
                 * jobs[j] + workAlreadyDone[up until i - 1][k jobs accepted] where k is 
                 * between j - 1 and i - 1 inclusive.
                 * 
                 * Notice that k at minimum will be the minimum number of jobs that could've been accepted
                 * up until the previous day. (yes you read that right)
                 * 
                 * The iteration below iterates on how many jobs were done up to the i-1th day using
                 * the above logic.
                 */     
                for (int k = j - 1; k >= i - 1; k--) {
                    minWork = Math.min(minWork, dp[i - 1][k] + currentDayDifficulty);
                    currentDayDifficulty = Math.max(currentDayDifficulty, jd[k]);
                }
                dp[i][j] = minWork;
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}