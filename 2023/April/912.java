/*
 * Sort an Array
 * 
 * Top 67% (33ms)
 * 
 * Merge sort implementation. Probably are ways to speed this up but I'm lazy.
 * 
 * Time complexity: O(nlgn)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length);

        return nums;
    }

    public void sortArray(int[] nums, int start, int end) {
        if (end - start > 1) {
            int mid = start + (end - start) / 2;
            sortArray(nums, start, mid);
            sortArray(nums, mid, end);
            merge(nums, start, mid, mid, end);
        }
    }
    
    public void merge(int[] nums, int startLeft, int endLeft, int startRight, int endRight){  
        int originalStart = startLeft;
        int[] mergedArray = new int[endRight - startLeft];  
        int indexM = 0;

        while (startLeft != endLeft && startRight != endRight) {
            if (nums[startLeft] <= nums[startRight]) {
                mergedArray[indexM] = nums[startLeft];
                startLeft++;
            }
            else {
                mergedArray[indexM] = nums[startRight];
                startRight++;
            }
            indexM++;
        }
        
        while (startLeft != endLeft) {
            mergedArray[indexM] = nums[startLeft];
            startLeft++;
            indexM++;
        }
        
        while (startRight != endRight) {
            mergedArray[indexM] = nums[startRight];
            startRight++;
            indexM++;
        }
        
        for (int i = 0; i < mergedArray.length; i++) {
            nums[i + originalStart] = mergedArray[i];
        }
    }
}