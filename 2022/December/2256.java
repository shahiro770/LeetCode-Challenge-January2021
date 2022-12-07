/**
 * Minimum Average Difference
 * 
 * Top 95% (16ms)
 * 
 * Get the prefix sums, and then your right sum will always be the total sum 
 * less the prefix sum up to that index.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int minimumAverageDifference(int[] nums) {
        long rightSum = 0;
        long leftSum = 0;
        long minAvg = Integer.MAX_VALUE;
        int minAvgIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            long avg;
            if (i == nums.length - 1) {
                avg = Math.abs(leftSum / (i + 1));
            }
            else {
                avg = Math.abs((leftSum / (i + 1)) - ((rightSum - leftSum) / (nums.length - i - 1)));
            }
            if (avg < minAvg) {
                minAvg = avg;
                minAvgIndex = i;
            }
        }

        return minAvgIndex;
    }
}

/*

[2, 7, 10, 19, 24, 27]
[2, 3, 3, 4, 4, 4]

*/