/*
 * Single Element in a Sorted Array
 * 
 * Top 100% (0ms)
 * 
 * Given its a sorted array and the question says lgn time, its easy to guess binary
 * search is involved. However, its used in a way that has little to do with the actual sorted order.
 * The sort lets us see if the number we are currently on is singular or not, given if it isn't,
 * its match should be adjacent to it. With that said:
 * 
 * 1) If there's an odd number of values to the left of mid index, 
 * the singular value must be to the left of the mid index since its impossible for every number in an odd length set to have a pair
 * 2) The search space for 1) is reduced by 1 if the duplicate value of the current is on the left
 * 
 * Time complexity: O(lgn)
 */

 class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int leftElements = -1;
        int ans = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            
            if (mid > 0 && nums[mid - 1] == nums[mid]) {
                leftElements = mid - 1;
                if (leftElements % 2 == 1) {
                    high = mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {
                leftElements = mid;
                if (leftElements % 2 == 1) {
                    high = mid; 
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                ans = nums[mid];
                break;
            }
        }

        return ans;
    }
}