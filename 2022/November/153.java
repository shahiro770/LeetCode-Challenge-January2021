/*
 * Find Minimum in Rotated Sorted Array
 * 
 * Top 100% (0ms) 
 * 
 * Similar to 295. But your logic is a little different with how you narrow your window.
 * 
 * Time Complexity: O(lgn)
 * */

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            
            // we are looking at the minimum element, which will be less than its neighoubrs
            if (mid > 0 && mid < nums.length - 1 && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }
            
            if (nums[left] <= nums[mid]) {
                // if mid is larger than left and right, then since right < left, the wrap around index
                // must be in the right half of the list
                if (nums[mid] > nums[right] ) {
                    left = mid + 1;
                }
                // otherwise, nums[mid] <= nums[right], which means the wrap around happened before mid
                else {
                    right = mid - 1;
                }
            }
            else {  // nums[left] > nums[mid], the wrap around must've happened before mid
                right = mid - 1;
            }
        }

        return nums[mid];
    }
}