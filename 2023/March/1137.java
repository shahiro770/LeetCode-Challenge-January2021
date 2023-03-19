/*
 * N-th Tribonacci Number
 *
 * Top 100% (0ms) 
 * 
 * Time Complexity: O(n);
 */

class Solution {
    public int tribonacci(int n) {
        int[] trib = new int[n + 1];

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;

        for (int i = 3; i < trib.length; i++) {
            trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
        }

        return trib[trib.length - 1];
    }
}