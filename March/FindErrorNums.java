/**
 * March 2021 Day 2
 * 
 * O(n) time
 */

class Solution {
    public int[] findErrorNums(int[] nums) {
        int sol[] = new int[2];
        int buck[] = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            buck[nums[i] - 1]--;    // -1 since the numbers go from 1 to nums.length
        }
        
        for (int i = 0; i < buck.length; i++) {
            if (buck[i] == 0) {
                sol[1] = i + 1;
            }
            if (buck[i] == -2) {
                sol[0] = i + 1;
            }
        }
        
        return sol;
    }
}