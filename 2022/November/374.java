/*
 * Guess Number Higher or Lower
 * 
 * Top 100% (0ms)
 * 
 * Once again an easy question I fail on the first try because int as a data type
 * is too small for leetcode.
 * 
 * Time Complexity: O(lgn)
 */

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = (left + right) / 2;
            int res = guess((int)mid);
            if (res == 0) {
                return (int)mid;
            }
            else if (res == -1) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}