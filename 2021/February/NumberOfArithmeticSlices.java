/**
 * Feb 2021 Day 18
 * 
 * Dumb pseudo DP question.
 * An arithmetic slice starts once you have at least 3 intgers
 *      From there, realize that if adding another integer to the slice makes a valid slice, the previous 3 
 *      (including the one just added) also contains any previous slices, in a bit of a pattern
 *          1 2 3 => 1 slice
 *          1 2 3 4 => 3 slices  1 2 3 4, as well as 1 2 3 and 2 3 4    
 *          1 2 3 4 5 => has all the slices of 1 2 3 4, plus 3 4 5, 2 3 4 5, and 1 2 3 4 5 (6 slices total)
 *      So the pattern to recognize is that in a consecutive chain of slices the # of slices up to a given index is
 *      slices[previous index] + 1. So in 1 2 3 4 5
 *          1 slices at [3]
 *          2 slices at [4]
 *          3 slices at [5]
 *      To be honest, I'm not too sure why this pattern exists, and recognizing that its a subproblem is sorta unintuitive.
 * 
 * Time complexity O(n)
 *          
*/

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] slices = new int[A.length];
        int total = 0;
        for (int i = 2; i < A.length; i++) {
            if ((A[i] - A[i - 1]) == (A[i - 1] - A[i - 2])) {
                slices[i] = 1 + slices[i - 1];
            }
            total += slices[i];
        }

        return total;
    }
}