/** 
 * In place and O(n), though it could probably be written better if I just made 
 * a swap function (which would be good for an interview).
 * 
 * This solution works as follows:
 *      1) Look at the number from right to left marking the index at which the numbers stop increasing
 *      2) Find the smallest number in the numbers to the right of the index that is larger than the number at the index
 *      3) Swap those two numbers
 *      4) Reverse the numbers to the right of the index
 *      5) If steps 1-4 fail (i.e. the nums array is sorted descending), just sort the array ascending
 * 
 * Why this works? 
 *      Look at [1, 2, 3]
 *          The next lexographically larger number is obviously 132
 *          We prioritize swapping the rightmost digits for the smallest change
 *      Look at [1, 3, 5, 4]
 *          The next larger is 1453
 *          Swapping 4 and 5 clearly gets us a smaller number, so swapping on an increasing pattern isn't the way
 *          Now swapping 3 with 4 or 5 gets us a larger number, but we want the NEXT smallest number, so we choose the smaller of the two (4)
 *          The answer now looks like 1453, but 1435 is certainly smaller
 *          Reverse the digits after the 4, as we know the digits after 4 follow an increasing pattern (hence the reverse must be smaller)
 *              Swapping 3 and 4 will preserve this increasing pattern since 4 is the smallest larger number
 *          Final answer is 1435              
*/

import java.util.*;

class Day31 {
    public void nextPermutation(int[] nums) {
        boolean sort = true;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                int tightestUpperIndex = -1;
                
                for (int j = nums.length - 1; j > i - 1; j--) {
                    
                    if (nums[j] > nums[i - 1] && (tightestUpperIndex == -1 || nums[j] < nums[tightestUpperIndex])) {
                        tightestUpperIndex = j;
                    }
                }
                if (tightestUpperIndex == -1) {
                    break;
                }
                sort = false;
                int temp = nums[i - 1];
                nums[i - 1] = nums[tightestUpperIndex];
                nums[tightestUpperIndex] = temp;
                
                int left = i;
                int right = nums.length - 1;
                
                while (left < right) {
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
                break;
            }
        }
        if (sort == true) {
            Arrays.sort(nums);
        }
    }
}