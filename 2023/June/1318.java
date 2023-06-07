/*
 * Minimum Flips to Make a OR b Equal to c
 * 
 * Top 100% (0ms)
 * 
 * Time Complexity: O(1) // worst  case its 32 iterations for size of int is 32 bits 
 */

class Solution {
    public int minFlips(int a, int b, int c) {
        int flipCount = 0;

        
        while (a > 0 || b > 0 || c > 0) {
            int rightMostA = a & 1;
            int rightMostB = b & 1;
            int rightMostC = c & 1;

            if (rightMostC == 0) {
                if (rightMostA == 1) {
                    flipCount++;
                }
                if (rightMostB == 1) {
                    flipCount++;
                }
            }
            else if (rightMostC == 1 && rightMostA == 0 && rightMostB == 0) {
                flipCount++;
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flipCount;
    }
}

/*
    a = 8 = 1000
    b = 2 = 0011
    c = 5 = 0101

*/