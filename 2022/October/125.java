/**
 * Valid Palindrome
 *
 * October 2022
 * Top 92% (4ms)  
 * 
 * Two pointer, but use isLetterOrDigit to save time cleaning the string
 * 
 * Time complexity: O(n)
 * */

class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;

        while (left < right) {
            if (Character.isLetterOrDigit(c[left]) == false) {
                left++;
            }
            if (Character.isLetterOrDigit(c[right]) == false) {
                right--;
            }
            if (Character.isLetterOrDigit(c[left]) == true && Character.isLetterOrDigit(c[right]) == true) {
                if (Character.toLowerCase(c[left]) != Character.toLowerCase(c[right])) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}