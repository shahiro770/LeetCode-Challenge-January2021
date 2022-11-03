/**
 * Continuous Subarray Sum
 *
 * Top 96% (19ms)
 * 
 * Modified solution of someone else's because mine was trash.
 * Math on this one is confusing:
 * 
 * Our answer needs two properties:
 * 1) the subarray includes 2 numbers
 * 2) the sum of the subarray % k = 0
 * 
 * Suppose we have two numbers a,b, where b > a. If b - a = d and d were to be a multiple of k then
 * d % k = 0
 * (b - a) % k = 0
 * b % k - a % k = 0
 * b % k = a % k.
 * 
 * How can we use this proof to find our subarray?
 * 1) Take the sum up to each spot in the array (prefix sum)
 * 2) Since the prefix sum a < prefix sum where a is the sum up to i, and b is the sum up to j, i < j
 * subtracing b - a is the equivalent to taking a subarray sum of (i,j].
 * 3) Using the proof above, b % k = a % k => (b - a) is a multiple of k
 * 3) If we can find duplicate mod values at any two different indices in the array, we will have 
 * found the start and end of the subarray that when summed will give us a multiple of k
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> modSet = new HashSet();
		// the prev sum logic is used to add the previous prefix sum to our set of sums
        // only after evaluating the next sum
        // this handles edge cases like nums = [1 ,0] and k = 2
        // where the mod would be the same on both indices, but clearly it isn't valid
        int prefixSum = 0;
        int prevPrefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefixSum %= k;
            if(modSet.contains(prefixSum)) {
                return true;
            }
            modSet.add(prevPrefixSum);
            prevPrefixSum = prefixSum;
        }
        return false;
    }
}