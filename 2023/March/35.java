/*
 * Search Insert Position
 *
 * Top 100% (0ms)
 * 
 * */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low < high) {
            mid = low + (high - low) / 2;
            
            if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid;
            }
            else {
                return mid;
            }
        }

        return nums[low] < target ? low + 1: low;
    }
}