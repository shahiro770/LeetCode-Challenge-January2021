/**
 * Remove Element
 * 
 * Top 100% (0ms)
 * 
 * Since the elements at the front's order doesn't matter, just swap with the back
 * of the array.
 * 
 * Time Complexity: O(n) 
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int sol = 0;
        while (left < right) {
            if (nums[left] == val) {
                while (nums[right] == val && right > left) {
                    right--;
                }
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }  
            if (nums[left] != val) {
                sol++;
            }
            left++;
        }

        // edge case for arrays with only val, as left will = right and
        // not count the last element
        if (nums.length > 0 && nums[left] != val) {
            sol++;
        }

        return sol;
    }
}