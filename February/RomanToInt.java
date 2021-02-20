/**
 * Feb 2021 Day 20
 * Top 99.91% I hate strings
 * 
 * Just do all of the cases. There's cleaner ways to write this but I think anyone could read this.
 * The smart trick to do is to compute IV = 5 - 1 = 4, similarly XL = 50 - 10 = 40 only if the next character is lower in value
 *      But I think this requires understanding roman numerals a little better
 * 
 * Time complexity is O(n)
 * 
*/

class Solution {
    public int RomanToInt(String s) {
        int val = 0;
        
        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'I') {
                if (i < chars.length - 1) {
                    char c2 = chars[i + 1];
                    if (c2 == 'V') {
                        i++;
                        val += 4;
                    }
                    else if (c2 == 'X') {
                        i++;
                        val += 9;
                    }
                    else {
                        val += 1;
                    }
                }
                else {
                    val += 1;
                }
            }
            else if (c == 'V') {
                val += 5;
            }
            else if (c == 'X') {
                if (i < chars.length - 1) {
                    char c2 = chars[i + 1]; 
                    if (c2 == 'L') {
                        i++;
                        val += 40;
                    }
                    else if (c2 == 'C') {
                        i++;
                        val += 90;
                    }
                    else {
                        val += 10;
                    }
                }
                else {
                    val += 10;
                }
            }
            else if (c == 'L') {
                val += 50;
            }
            else if (c == 'C') {
                if (i < chars.length - 1) {
                    char c2 = chars[i + 1]; 
                    if (c2 == 'D') {
                        i++;
                        val += 400;
                    }
                    else if (c2 == 'M') {
                        i++;
                        val += 900;
                    }
                    else {
                        val += 100;
                    }
                }
                else {
                    val += 100;
                }
            }
            else if (c == 'D') {
                val += 500;
            }
            else if (c == 'M') {
                val += 1000;
            }
        }
        
        return val;
    }
}