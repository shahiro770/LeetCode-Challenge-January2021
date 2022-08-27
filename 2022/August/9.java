/**
 * Palindrome Number
 * 
 * Top 87% (11ms)
 * 
 * Converting to string is the easy way out. Hard way is as follows:
 * 1) If the number is negative or if the number is divisible by 10 with no remainder it clearly isn't a palindrome
 * 2) Otherwise, replicate the left side of the number from the right
 *      2.1) Chop the right digit off of x and add it to the reverse
 *      2.2) Multiply the reverse by 10 and repeat 
 *      2.3) Repeat 2.1 and 2.2 until the reverse is larger than x (i.e. the halfway point)
 * 3) If the number is even, x and the reverse should be equal. Otherwise the reverse/10 should be equal to x
 *    since x is will be missing the middle digit
 * 
 **/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;  
        } 
you
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return (x == reverse || x == reverse / 10);
    }
}
