/*
    Feb 2021 Day 23

    Start top right
        If the value there is greater than target must be in a previous column since columns are ascending
        If the value there is not greater and not a match, then go to the next row since rows are ascending 
        If its a match return
    
        Time complexity is O(m + n) where m is row length and n is col length and worst case scenario we go through both 
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
       
        while (i != matrix.length && j != -1) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        
        return false;
    }
}