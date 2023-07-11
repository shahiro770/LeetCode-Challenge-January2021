/**
 * Minimum Size Subarray Sum
 *
 * Top 99% (1ms)
 * 
 * Somewhat straightforward sliding window. Expand the window until we have the sum, then move up the rear,
 * recording the smallest valid window we've seen throughout the process.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        while (left < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= target && left < nums.length) { 
                if (sum >= target) {
                    minLength = Math.min(minLength, right - left);
                }
                sum -= nums[left];
                left++;
            }

            if (right == nums.length) {
                while (sum >= target && left < nums.length) { 
                    if (sum >= target) {
                        minLength = Math.min(minLength, right - left);
                    }
                    sum -= nums[left];
                    left++;
                }
                break;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }
}