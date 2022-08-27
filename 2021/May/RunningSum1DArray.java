/**
 * May 2021 Day 3
 * 
 * Time Complexity O(n)
 */

public class RunningSum1DArray {
    public int[] runningSum(int[] nums) {
        if (nums.length < 1) {
            return new int[0];
        }
        int[] out = new int[nums.length];
        out[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            out[i] = out[i - 1] + nums[i];
        }
        
        return out;
    }
}