/**
 * Feb 2021 Day 15
 * Top 72.86% because 2ms isn't good enough
 * 
 * Have a class with a custom comparator makes sorting and spitting out the indices easy
 * 
 * Time complexity should be O(M*N)
 * Faster solution for that 1 or 0ms time:
 *      Binary search each row for the last 1 and first 0 to get the index at logn time over n time
*/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        Army[] armies = new Army[m];
        
        for (int i = 0; i < m; i++) {
            armies[i] = new Army(i);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    armies[i].power++;
                }
                else {
                    break;
                }
            }
        }
        
        Arrays.sort(armies);
        int[] weaks = new int[k];
        
        for (int i = 0; i < k; i++) {
            weaks[i] = armies[i].index;
        }
        
        return weaks;
    }
    
    private class Army implements Comparable<Army> {
        int index;
        int power;
        
        private Army(int index) {
            this.index = index;
            power = 0;
        }
        
        @Override
        public int compareTo(Army otherArmy) {
            if (otherArmy.power == power) {
                return index - otherArmy.index;
            }
            return power - otherArmy.power;
        }
    }
}