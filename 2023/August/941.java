/*
 * Valid Mountain Array
 *
 * Top 100% (1ms)
 * 
 * Time Complexity: O(n)
 */


class Solution {
    public boolean validMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        if (arr.length < 3 || arr[start] > arr[start + 1] || arr[end] > arr[end - 1]) {
            return false;
        }

        while (start < arr.length && arr[start] < arr[start + 1]) {
            start++;
        }
        while (end > 0 && arr[end] < arr[end - 1]) {
            end--;
        }

        return start == end;
    }
}