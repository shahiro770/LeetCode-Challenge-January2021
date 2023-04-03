/**
 * Count Odd Numbers in an Interval Range
 * 
 * Top 100% (0ms)
 * 
 * A little pattern can be observed by doing some test cases with the first or last numbers being odd.
 * 
 * Time complexity: O(1); 
 */

class Solution {
    public int countOdds(int low, int high) {
        if (high % 2 == 1 || low % 2 == 1) {
            return (high - low) / 2 + 1;
        }
        return (high - low) / 2;
    }
}

/*
    7 - 3 = 4 / 2 = 2 (wrong, 3, 5, 7)
    6 - 4 = 2 / 2 = 1 (right, 5)
    6 - 1 = 5 / 2 = 2 (wrong, 1, 3, 5)
    10 - 1 = 9 / 2 = 4 (wrong 1,3, 5, 7,9)
    10 - 2 = 8 / 2 = 4 
*/