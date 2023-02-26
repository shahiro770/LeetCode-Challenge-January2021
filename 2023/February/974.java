/*
 * Subarray Sums Divisible by K
 *
 * Top 87% (4ms) 
 * 
 * Why is this medium and not hard.
 * 
 * So obviously, the sum of the subArray / k has to be 0 to be considered towards the solution.
 * The prefix sum logic with subarrays is a little tricky but shows up from time to time. Just a refresher:
 *      If we had an array = [0, 1, 2, 3 ,4, 5]
 *      prefixSums = [0, 1, 3, 6, 10, 15]
 *          prefixSums[0] = [0]
 *          prefixSums[1] = [0 + 1]
 *          prefixSums[2] = [0 + 1 + 2]
 *          prefixSums[3] = [0 + 1 + 2 + 3]
 *          ...
 *      Notice if we do prefixsums[3] - prefixsums[1], we get the sum of [2 + 3]
 *          In other words, subtracting prefix sums gives us different subarrays, in particular
 *              prefixsums[i] - prefixSums[j] = subArrayWithelements[i, i - 1, i - 2, ..., i - j], where i < j
 * 
 * Now this question is asking for % k, so we want to find all (prefixSums[i] - prefixSums[j]) / k = 0, where i < j
 *      This seems n^2 on the surface since we're pairing all possible j's with i's, but there's a trick here (kinda number theory)
 *          Referring prefixSums[] to pS[], suppose we expressed pS[i] and ps[j] according to the division algorithm
 *              pS[i] = ak + r1, 0 <= r1 < k
 *              pS[j] = bk + r0, 0 <= r0 < k
 *          Now lets sub these formulas back into the equation above
 *              (aK + r1) - (bk + r0) / k = 0
 *              (ak + r1 - bk - r0) / k = 0
 *              (k(a - b) + (r1 - r0)) / k = 0
 *              k(a - b) / k + (r1 - r0) / k = 0
 *                  Clearly, the subtraction of remainders r1 - r0 must also equal 0 in order for the subarray sum to equal 0
 *  
 * Now suppose with k = 3, we take the mod of the prefixSums (as this will show us the remainders) for our array
 *      modPrefixSums = [0, 1, 0, 0, 1, 0]
 *          Anywhere two i,j that have equal remainders will form a subArray divisibly by k. 
 *              e.g. i = 2, j = 0 
 *                  [1, 2] = 3, 3 / 3 = 1, no remainder = divisible
 *              e.g. i = 4, j = 1
 *                  [2, 3, 4] = 9, 9 / 3 = 3, no remainder = divisible
 *           Also notice how there are multiple combos. Any i,j with a 0 could form a valid subarray with another 0
 *              There are 6 possible combinations for remainder 0 as a result, only 1 combination for remainder 1
 *           And of course, if we do see a remainder 0, that says the subArray from index 0 to i is also valid
 *              This gives us 4 more 
 *          The final count in this case is 11
 *          
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];           // count of all prefixSums with the same remainder 
        int prefix = 0;
        int sol = 0;

        count[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]);
            prefix = (prefix % k + k) % k;  // % k would be enough if it was all positives, but (% k + k) % k is a hack to deal with negatives
            sol += count[prefix]++;         // with every matching prefixsum we discover, it adds a new pair for a previous match, so we "add the old ones again"
        }

        return sol;
    }
}