/*
 * Count Subarrays With Fixed Bounds 
 * 
 * Top 74% (7ms)
 * 
 * Keep track of the last time you saw a  number outside of the range (leftBound), as well as the range defining
 * min and max values. If the leftBound is before both of those values, we have a number of valid subarrays
 * equal to the minimum index of the min/max values less the position of the left bound (as we can take
 * any number of indices after the left bound to form a valid subarray)
 * 
 * The only confusion might come from the idea of what happens to numbers after the min/max values that are
 * still valid in the subarray. How are they counted? Suppose we had:
 * 
 * minK = 1
 * maxK = 3
 * 
 * arr [5, 1, 2, 3, 2, 4]
 * ind  0  1  2  3  4  5
 * 
 * 5 would end up as the left bound until the very last iteration, and we'll have a proper boundary
 * at index 3 (sol = 1). But at index 4, what happens? minK and maxK won't update but [1,2,3,2] is valid.
 *      sol would just increment by 1 again, since the identical previous calculation would occur.
 *          If sol had incremented by n, we would want to add n again
 *              For each index after the subrange with nums[index] in range, we are effectively extending the
 *              size of each subarray that was valid before by 1, so for a subarray of length n, we get n more subarrays.
 * 
 * Time complexity: O(n)
*/

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int leftBound = -1;
        int lastMinK = -1;
        int lastMaxK = -1;
        long sol = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                lastMinK = i;
            }
            if (nums[i] == maxK) {
                lastMaxK = i;
            }

            if (leftBound < lastMinK && leftBound < lastMaxK) {
                sol += Math.min(lastMinK, lastMaxK) - leftBound;
            }
        }

        return sol;
    }
}