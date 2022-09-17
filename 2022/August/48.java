/**
 * Rotate Image
 * 
 * August 2022
 * Top 100% (0ms)
 * 
 * First flip the matrix on horizontal and then swap on the diagonal.
 * 
 * Time Complexity: O(n)
 */ 

class Solution {
    public void rotate(int[][] matrix) {
        int[] tempArray;
        int temp;
        for (int i = 0; i < matrix.length / 2; i++) {
            tempArray = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = tempArray;
        }   
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {   // i + 1 prevents us from double symmetry swapping
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}