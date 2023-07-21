/*
 * Element Appearing More Than 25% In Sorted Array
 * 
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int findSpecialInteger(int[] arr) {
        int thres = (int)(arr.length * 0.25f);
        
        for (int i = 0; i < arr.length - thres; i++) {
            if (arr[i] == arr[i + thres]) {
                return arr[i];
            }
        }

        return -1;
    }
}