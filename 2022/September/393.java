/**
 * UTF-8 Validation
 * 
 * September 2022
 * Top 86% (2ms)
 * 
 * Take the most significant 5/4/3/2 bits for each number
 * Case 1) If the first 5/4/3 bits match the UTF pattern, test the next 3/2/1 numbers if they have 10 as their most significant bits
 * Case 2) If not case 1), just check if the most significant bit is a 0 
 *
 * Time complexity: O(n)
 */

class Solution {
    public boolean validUtf8(int[] data) {
        int pos = 0;
        boolean utfTestResult = true;
        int mostSignificant;
        
        while (pos < data.length) {
            if ((data[pos] & 248) == 240) {
                utfTestResult =utfTest(data, pos, 3);
                if (utfTestResult == false) {
                    break;
                }
                pos += 4;
            }
            else if ((data[pos] & 240) == 224) {
                utfTestResult = utfTest(data, pos, 2);
                if (utfTestResult == false) {
                    break;
                }
                pos += 3;
            }
            else if ((data[pos] & 224) == 192) {
                utfTestResult =utfTest(data, pos, 1);
                if (utfTestResult == false) {
                    break;
                }
                pos += 2;
            }
            else if ((data[pos] & 128) != 0) {
                utfTestResult = false;
                break;
            }
            else {
                pos++;
            }
        }
        
        return utfTestResult;
    }
    
    private boolean utfTest(int[] data, int pos, int numbersToTest) {
        if (pos + numbersToTest > data.length) {
            return false;
        }
        for (int i = 1; i <= numbersToTest; i++) {
            if ((data[pos + i] & 192) != 128) {
                return false;
            }
        }
        return true;
    }
}

/*
[197,130,1]
[235,140,4]
[235,140,4,255]
[230,136,145]
[145]
*/