/*
 * Keyboard Row
 *
 * Top 95% (2ms)
 * 
 * See https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/solutions/252254/java-c-python-sort/
 * lee215's brain is bigger than mine
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
      	int min = Integer.MAX_VALUE, sum = 0;
        Arrays.sort(nums);
        // go through the whole array and flip negatives to positivev
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] < 0 && k > 0 ) {
                nums[i] = -nums[i];
                k --;
            }
            // keep track of the min number at the same time
            if (nums[i] < min ) {
                min = nums[i];
            }
            sum += nums[i];
        }

        // since we can flip the same index infinite times, as long as we have even k, we don't need to do anything extra
        // if k is odd, the smallest number will need to be flipped one extra time
        if (k > 0 && k % 2 != 0 ) {
            sum += -2 * min;
        }
        return sum;
    }
}