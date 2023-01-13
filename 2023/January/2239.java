/*
 * Longest Subsequence With Limited Sum
 *
 * Top 88% (5ms)
 * 
 * The question says subsequence, but in the case of this question, order doesn't matter.
 * All we care about is greedily picking the smallest numbers until the sum exceeds the query.
 * Sorting the array in ascending order, then doing a prefix sum will give us all the possible "greedy" sums.
 * Binary search for the one that is <= the query will give the answer.
 * 
 * Time Complexity: O(nlgn)
 * */

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sums = new int[nums.length];
        int[] sol = new int[queries.length];
    
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int low = 0;
            int high = sums.length - 1;
            int mid = 0;

            while (low <= high) {
                mid = (low + high) / 2;
                if (sums[mid] > queries[i]) {
                    high = mid - 1;
                }
                else if (sums[mid] == queries[i]) {
                    break;
                }
                else {
                    low = mid + 1;
                }
            }
            /*
             * Only catch in this question. Should sums[mid] > the query, take the sum that is right before sums[mid].
             * By the process of binary search, this value must be less than sums[mid] and less than the query, 
             * as we would not have tested sums[mid] if on the previous iteration sums[mid] was greater than the query.
             */
            if (sums[mid] > queries[i]) {
                sol[i] = mid;
            }
            else {
                sol[i] = mid + 1;
            }
        }

        return sol;
    }
}