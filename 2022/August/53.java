/**
 * Maximum subarray
 * 
 * Top 100% (1ms)
 * 
 * Its kadane's algorithm but be prepared to handle the negative only array.
 * What's kadane's algorithm?
 * 
 * There's an optimal substructure when trying to find the max sub array in that you only
 * want to include positive numbers. In otherwords, we'd only include A[n] in our current 
 * list of A[k1] + ... + A[km] if A[n] didn't reduce our sum. But there's a catch here.
 * 
 * We don't want to wipe out our current max sub array and start a new if we just found a single negative number.
 * e.g. in [4, 2, -1, 4] the max subarray is the whole array with a sum of 9, but encountering a -1 with our current
 * set up would leave us with 4. So what is the condition for resetting?
 * 
 * Adding a negative number to a non-positive number will always give us a smaller number. This
 * is how we know we can't do any better with the current array and need to scrap it.
 * 
 * Time Complexity: O(n)
 */ 


class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere += nums[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);   // in the event the entire array is negatives
             
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        
        return maxSoFar;
    }
}