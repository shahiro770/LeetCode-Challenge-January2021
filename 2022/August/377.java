/**
 * Combination Sum IV
 * Aug 2022 Day 5
 * Top 65% (2ms)
 * 
 * DP question. Store the number of combinations to get each number up to the target starting from 1.
 * If you know the number of combinations for i - j, we can add that to the number of combinations for i,
 * where j is the current number you're looking at in the elements array.
 *
 * Time complexity: O(t * n), where t is the target and n is the number of elements
 */

class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] targetCombos = new int[target + 1];
        targetCombos[0] = 1;    // 0 isn't a possible input, but if we can reduce a target to 0 a combination exists
        
        for (int i = 1; i < targetCombos.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // There's no point in examining elements if they can't give us the target
                if (nums[j] <= i) {
                    targetCombos[i] += targetCombos[i - nums[j]];
                }
            }
        }
        
        return targetCombos[target];
    }
}
