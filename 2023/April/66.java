/*
 * Plus One
 * 
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n) 
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] + carry == 10) {
                carry = 1;
                digits[i] = 0;
            }
            else {
                digits[i] += carry;
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                newDigits[i] = digits[i - 1];
            }

            return newDigits;
        }

        return digits;
    }
}