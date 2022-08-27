/**
 * March 2021 Day 3
 * 
 * Sum all the numbers 0 to n, then subtract all numbers in the array, remainder will be the missing number
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
           sum += i;
        }   
        
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        
        return sum;
    }
}