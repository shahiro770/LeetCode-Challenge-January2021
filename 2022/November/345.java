/*
 * Reverse Vowels of a String
 *
 * Top 98% (3ms)
 * 
 * This one is for mehdi's future girlfriend.
 * 
 * Time Complexity: O(n) where n is the length of the string 
 */

class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int[] indices = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            if (isVowel(c[i])) {
                indices[i] = i;
            }
            else {
                indices[i] = -1;
            }
        }

        int right = c.length - 1;
        int left = 0;

        while (left < right) {
            if (indices[left] == -1) {
                left++;
            }
            else if (indices[right] == -1) {
                right--;
            }
            else {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
        }

        return new String(c);
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}