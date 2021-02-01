import java.util.*;

class Day23 {
    public int[][] diagonalSort(int[][] mat) {
        int startx = mat.length;
        int starty = 0;
        int x = 0;
        int y = 0;
        int index = 0;
        int maxDiag = Math.min(mat.length, mat[0].length);
        boolean incY = false;
        
        for (int i = 0; i < mat.length + mat[0].length - 1; i++) {
            int[] currentDiag = new int[maxDiag];
            Arrays.fill(currentDiag, 101);
            
            if (startx > 0) {
                startx--;
            }
            else if (incY               == true){
                starty++;
            }
            
            x = 0;
            y = 0;
            index = 0;
            while (startx + x < mat.length && starty + y < mat[0].length) {
                currentDiag[index] = mat[startx + x][starty + y];
                index++;
                x++;
                y++;
            }
            
            Arrays.sort(currentDiag);
            
            x = 0;
            y = 0;
            index = 0;
            while (startx + x < mat.length && starty + y < mat[0].length) {
                mat[startx + x][starty + y] = currentDiag[index];
                index++;
                x++;
                y++;
            }
            
            if (startx == 0 && starty == 0) {
                incY = true;
            }
        }
        
        return mat;
    }
}