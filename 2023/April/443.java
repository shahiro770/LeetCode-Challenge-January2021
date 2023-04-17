/*
 * String Compression
 * 
 * Top 95% (1ms)
 * 
 * Somewhat straightforward array problem. The only tricky part is translating the number into the char array.
 * 
 * Time complexity: O(n)
 */

class Solution {
    // global variables because I'm lazy
    int currChar = 0;
    int charCount = 0;
    int numLength = 0;
    int compressedStringLength = 0;

    public int compress(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars[currChar]) {
                charCount++;  
            }
            else {
                modifyChars(chars);
                currChar = i;
                charCount = 1;
            }
            /*
             * When we reach the end, there are two cases:
             * 1) Current character is the same as the observed character([...'c', 'c', c'])
             * 2) We get a new character ([...'c', 'c', d'])
             * 
             * 1) will not modify the char array, and while 2) will modify the char array for 'c',
             * it won't do so for 'd'. In both cases we need to do a final modification with whatever we have
             */
            if (i == chars.length - 1) {
                modifyChars(chars);
                currChar = i;
                charCount = 1;
            }
        }
        return compressedStringLength;
    }

    private void modifyChars(char[] chars) {
        chars[compressedStringLength] = chars[currChar];
        
        if (charCount > 1) {
            numLength = String.valueOf(charCount).length(); 
            for (int j = compressedStringLength + numLength; j > compressedStringLength; j--) {
                chars[j] = (char)(charCount % 10 + '0');
                
                charCount /= 10;
            }
            compressedStringLength += numLength + 1;
        }
        else {
            compressedStringLength += 1;
        }
    }
}