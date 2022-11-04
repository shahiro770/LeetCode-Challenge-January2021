/**
 * Image Overlap
 *
 * Top 40% (79ms)
 * 
 * You effectively have img1 with padding of n - 1 0s on all sides and are taking an
 * n x n snapshot of each spot possible and seeing which snapshot gives the most overlap.
 * 
 * Time Complexity: O(n^4). Not my best but other solutions do the same but more optimized
 * (mainly they don't waste time creating my padded array, but I prefer this for conceptualizing
 * the problem easier)
 * */

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int x1 = img1[0].length;
        int y1 = img1.length; 
        int y2 = y1 * 3 - 2;
        int x2 = x1 * 3 - 2;
        int[][] padCopy = new int[y2][x2];
        int overlap = 0;

        for (int i = 0; i < y1; i++) {
            for (int j = 0; j < x1; j++) {
                padCopy[i + y1 - 1][j + x1 - 1] = img1[i][j];
            }
        }

        // for (int i = 0; i < y2; i++) {
        //     System.out.println("");
        //     for (int j = 0; j < x2; j++) {
        //         System.out.print(img1Copy[i][j] + " ");
        //     }
        // }

        for (int i = 0; i < y2 - y1 + 1; i++) {
            for (int j = 0; j < x2 - x1 + 1; j++) {
                overlap = Math.max(overlap, compareImgs(padCopy, i, j, img2));
            }
        }

        return overlap;
    }

    public int compareImgs(int[][] img1, int y1, int x1, int[][] img2) {
        int x2 = img2[0].length;
        int y2 = img2.length; 
        int overlap = 0;

        for (int i = 0; i < y2; i++) {
            for (int j = 0; j < x2; j++) {
                if (img2[j][i] == 1 && img1[j + y1][i + x1] == img2[j][i]) {
                    overlap++;
                }
            }
        }

        return overlap;
    }
}