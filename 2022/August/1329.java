/**
 * August 2022
 * Top 93% (2ms)
 * 
 * This is just a tricky indexing problem for getting the diagonals into arrays,
 * sorting them, and then putting them back in. 
 *
 * Time complexity: O(n * m + min(n,m)log(min(n,m))) 
*/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int diagLength;
        int maxDiagLength = Math.min(mat[0].length, mat.length);
        for (int i = 1; i < mat.length; i++) {
            diagLength = Math.min(maxDiagLength, mat.length - i);
            int[] diagonal = new int[diagLength];
            for (int j = 0; j < diagonal.length; j++) {
                diagonal[j] = mat[i + j][j];
            }
            Arrays.sort(diagonal);
            
            for (int j = 0; j < diagonal.length; j++) {
                mat[i + j][j] = diagonal[j];
            }
        }
        
        for (int i = 0; i < mat[0].length; i++) {
            diagLength = Math.min(maxDiagLength, mat[0].length - i);
            int[] diagonal = new int[diagLength];
            for (int j = 0; j < diagonal.length; j++) {
                diagonal[j] = mat[j][i + j];
            }
            Arrays.sort(diagonal);
            
            for (int j = 0; j < diagonal.length; j++) {
                mat[j][i + j] = diagonal[j];
            }
        }
        
        return mat;
    }
}