/*
 * Remove Duplicates from Sorted Array
 *
 * Top 100% (1ms) 
 * 
 * Have a slow pointer and fast pointer. If the slow and fast ever match, -1 the value at fast.
 * Otherwise, move the slow up and make it the value of the fast.
 * If they ever point to the same index, move up the fast.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast] && slow != fast) {
                nums[fast] = -1;
                fast++;
            }
            else if (slow == fast) {
                fast++;
            }
            else {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}