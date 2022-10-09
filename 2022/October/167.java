/**
 * Two Sum II - Input Array Is Sorted
 *
 * October 2022
 * Top 84% (2ms)  
 * 
 * Two pointer that abuses the sorted array to move towards the target
 * 
 * Time complexity: O(n)
 * */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            }
            if (target > sum) {
                left++;
            }
            else {
                right--;
            }
        }

        return null;
    }
}