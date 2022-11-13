/*
 * Search in Rotated Sorted Array
 * 
 * Top 82% (1ms) 
 * 
 * There's four cases you need to look at to handle this question when binary searching
 * Given a left, right, and mid (assuming target exists, otherwise it will eventually try all
 * logical options in lgn time and we'll return -1):
 * 
 * Case 1: nums[left] <= nums[mid]
 *      This means we know on the left side of our search window, the numbers are strictly increasing.
 *      Given this logic:
 *      Case 1.1: target > nums[mid]
 *          Our target is larger than the largest value in the search window. Target must be on the right then.
 *      Case 1.2: target < nums[left]
 *          Our target is smaller than the smallest value on the left. Since we have target < nums[left] <= nums[mid],
 *          the window also doesn't contain our number and we narrow to the right as well.
 *      Case 1.3: target < num[mid] and target > nums[left]
 *          If 1.1 and 1.2 are false, we can say with certainty the target is in the left.
 *  Case 2: nums[left] > nums[mid]
 *      The left side is larger than the middle value, meaning the "wrap around" occurrs on the left side
 *      of the search window. Here's where it gets tricky.
 *      Case 2.1: target < nums[mid]
 *          Due to knowing that both the highest and lowest values are to the left of mid (because thats
 *          where the numbers wrap), if our target is less than the mid, it must be on the left side.
 *      Case 2.2: target > nums[right]
 *          Through 2.1, we know the largest and smallest values are on the left side of the search window.
 *          If target is also larger than the rightmost value, then target must be on the left side.
 *      Case 2.3: target > nums[mid] and target < nums[right]
 *          If 2.1 and 2.2 are both false, we narrow the window to the right.
 *          
 * Time Complexity: O(lgn)
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println(left + " " + mid + " " + right);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }    
            else { // if (nums[left] > nums[mid]) {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}

/*
T = 

4,5,6,7,0,1,2
L     M     R

T = 6

1,2,3,4,5,6,0
L     M     R
*/