/**
 * Kth Smallest Element in a Sorted Matrix
 * Aug 2022 Day 2
 * 
 * Top 74% (2ms) 
 * 
 * Cool usage of binary search. So say your sorted 2d array was a 3x3 and k = 8.
 * 
 * 1 2 4
 * 4 4 6
 * 7 8 9
 * 
 * 1st Iteration:
 * The smallest element will always be 1 and the largest element will be 9.
 * Taking the middle value (1 + 9) / 2 = 5, we count the number of elements <= middle.
 * In this case, there are 5 elements (1, 2, 4, 4, 4). We want k = 8, so we change our window's smallest
 * to be middle + 1 = 6 (since count < k. We'd set highest = middle -1 otherwise)
 * 
 * 2nd Iteration:
 * (6 + 9) / 2 = 7.5 (truncate to 7).
 * Number of elements <= 7 is 7 this time (1 ,2 ,4, 4, 4, 6, 7). 
 * 7 < k = 8 so we shrink our window again from the lower side, low = 8.
 * 
 * 3rd Iteration:
 * (8 + 9) / 2 = 8.5 (truncate to 8)
 * Number of elements <= 8 is 8 this time (1, 2 ,4 ,4, 4, 6, 7, 8).
 * We found a number such that 8 other numbers in the array are smaller in the array.
 * But is that number in the array? In this case it is but in other cases it may not be,
 * and the corresponding value in the array is larger or smaller.
 * 
 * This solution will repeat until the window shrinks such that the middle value
 * is a number in the array. There may be some wasted iterations.
 * 
 * Time Complexity: O(nlogn) where n is the total number of elements in the 2d array
 * 
 * */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n -1][n -1];
        int count = 0;
        int ans = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            count = countNums(matrix, mid);
            
            if (count < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    public int countNums(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= mid) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }
}