/**
 * February 2021 Day 27 
 * 
 * Medium difficulty bit manipulation, hard difficulty if you got no idea how to bit manipulate around
 * the inability to divide (and the stupid long size restriction)
 * 
 * How this works 
 *  1) Check a or b are less than 0
 *      If they are, take the 2's complement to make them positive, and then track if the final solution will be negative or positive
 *  2) If the result will be negative, call solve(), returning the negative of the solution
 *  3) Within the recursive function solve
 *      If dividend is less than divisor, return 0
 *      Else 
 *          Take a copy of the divisor and bit shift to the left until it is larger than the dividend
 *          Record the number of shifts
 *          Return the value 1 shifted to the left by the same number of shifts 
 *              Plus solve(dividend less the divisor shifted by the amount, divisor)
 *      Why does this work? Take the value 37 divided by 3 (call stack is simplified)
 *          Depth 0 
    *          Shift 3 until its next shift would be larger than 37
    *              3 << 6 << 12 << *24* << 48 => 3 shifts
    *          Now 1 shifted 3 times
    *              1 << 2 << 4 << 8
    *          Solution is now 8 + solve(37 - 24, 3) = 8 + solve(13, 3)
            Depth 1
 *              Shift 3 until its next shift would be larger than 13
 *                  3 << 6 << *12* << 24 => 2 shifts
 *              Now 1 shifted 2 times
 *                  1 << 2 << 4
 *              Solution is now 8 + 4 + solve(13 - 12, 3) = 12 + solve(1, 3)
 *          Depth 2
 *              1 < 3 return 12 + 0
 *      As you can see, shifting is basically giving us our multiplication
 *          Shifting on 1 is effectively how many times our divisor went into the dividend for before we had to look at a smaller number
 *              Similar to long division
 *          Also need to realize because we're shifting on our divisor, the number of times the number goes in are counted 2^n
 *              Which is why we add the shifted 1 to match the number of division operations
 *  4) If the result is greater than the maximum possible interger value or less than the minimum integer value, return the max value
 *          Something something bit overflow
 * 
 *  Time complexity: I have no idea
 */

class Solution {
    private long solve(long a, long b) {
        if (a < b) {
            return 0; 
        }       
        long shifted = 0;
        long c = b;
        while ((c << 1) <= a) {
            shifted++;
            c = c << 1;
        }
        return (1L << shifted) + solve(a - (b << shifted), b);
    }

    public int divide(long a, long b) {
        boolean neg = false;
        if (a < 0) {
            a = ~(a) + 1;
            neg = !neg;
        }
        if (b < 0) {
            b = ~(b) + 1;
            neg = !neg;
        }
        long res = neg ? -solve(a, b) : solve(a, b);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)res;
    }
}