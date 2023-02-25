/**
 * Maximum Sum Circular Subarray
 *
 * Top 81% (3ms)
 * 
 * Weird min subarray question. If the max subarray is in the middle of the array without having to wrap around, then
 * kadane's algo is enough (and handle negatives using INTEGER.max_value as your initial value knowing the array is always
 * size > 0). But if does need to wrap around this gets harder and I couldn't get it myself. lee215 bless you for the below logic.
 * 
 * If you view a circular array as [prefix1 suffix1][prefix2 suffix2]
 *      Then the wrap arround solution is [suffix1, prefix2]. It turns out that whatever we don't take forms the minimum sub array sum.
 *          Why?
 *              1) Assume we need to take the first and last values of the array 
 *                  Otherwise max is in the middle or the whole array, and both of those cases are resolved by kadane's algo
 *              2) Assume that suffix1 extends left until its sum is maximized
 *              3) Assumem that prefix1 extends right until its sum is maximized  
 *              4) We can assume the sum of the values excluded were negative
 *                  Otherwise we would've taken all of them knowing the total result would be positive
 *                      From here we can safely assume that these values constitute the minimum subArray in the circular array
 *          Two ways to get this value:
 *              1) Flip all the values from neg to pos or vice versa, then kadane that
 *              2) Just do an inverse of kadane on the array in the first pass (only add values less than 0, etc.)
 * 
 * The final answer has a little nuance
 *      It will be the maximum of the maxSubArray, and totalSum - minSubArray 
 *          However, if the maxSubArray gets us a negative value, totalSum - minSubArray will give a large positive number
 *              So return maxSubArray in this case
 *
 * Time Complexity: O(n)
 */

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxSum = 0;
        int minSoFar = Integer.MAX_VALUE;
        int minSum = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            maxSum += nums[i];
            if (maxSoFar < maxSum) {
                maxSoFar = maxSum;
            }
            if (maxSum < 0) {
                maxSum = 0;
            }
            minSum += nums[i];
            if (minSoFar > minSum) {
                minSoFar = minSum;
            }
            if (minSum > 0) {
                minSum = 0;
            }
        }

        return maxSoFar > 0 ? Math.max(maxSoFar, total - minSoFar) : maxSoFar;
    }
}