/**
 * Maximum Profit in Job Scheduling
 * 
 * Top 99% (13ms)
 * 
 * Time Complexity: O(nlogn)
 * */

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Job[] jobs = new Job[startTime.length];
        for(int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        // sort the jobs by end times in ascending order
        Arrays.sort(jobs);

        /*
        dp[i] = max profit possible  using any combination of the first i jobs
        */
        int[] dp = new int[jobs.length];
        dp[0] = jobs[0].prof;
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            /*
                For all previous jobs, find the first job  that doesn't overlap with the  ith job.
                If the sum of taking the most profitable combo for that job + the ith job gives us more profit
                than the current dp[i], it is the better combo.
                We don't need to check farther as previous iterations will already have ruled out inefficient
                dp[j] + jobs[i].profit combos, or would have carried that value already over to dp[i]
                if it was the best and validating against the newest combo is all that needs to be tested.
            */
            for(int j = i - 1; j >= 0; j--) {  
                if (jobs[i].start >= jobs[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].prof);
                    break;
                } 
            }
            // In the event the ith job is just better than any combination of what came before,
            // dp[i] = jobs[i].prof.
            dp[i] = Math.max(dp[i], jobs[i].prof);
        }

        return dp[dp.length - 1];
        
    }

    public class Job implements Comparable<Job>{   
        int start; 
        int end; 
        int prof;

        public Job(int start, int end, int prof) {
            this.start = start;
            this.end = end;
            this.prof = prof;
        }

        @Override
        public int compareTo(Job job) {
            return this.end < job.end ? -1 : 1;
        }

        @Override
        public String toString() {
            return this.start + " " + this.end;
        }
    }
}