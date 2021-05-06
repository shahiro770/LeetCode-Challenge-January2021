/**
 * May 2021 Day 4
 * 
 * Whenever we see the next number is smaller than the current for the first time, there's two things we can do
 * (you can see this pattern with enough test cases):
 *      1) the number before is less than the next number; make the current number equal to the next number then to maintain order
 *      2) the number before is larger than the next number; make the next number equal to the current to maintain order
 *      3) there is no number before; make the current number equal to the next number (since by definition this is most advantageous)
 * 
 * Obviously, a second array modification will return false
 * 
 * Time Complexity O(n)
 */

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean canModify = true;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (canModify == true) {
                    if (i == 0 || (i > 0 && nums[i - 1] <= nums[i + 1])) {
                        nums[i] = nums[i + 1];
                    }
                    else {
                        nums[i + 1] = nums[i];
                    }
                    canModify = false;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
