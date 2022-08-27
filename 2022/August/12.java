/*
 * Integer to Roman
 * 
 * Top 79% (8ms)
 * 
 * Just subtract based on the the number until it falls into the next threshold.
*/

class Solution {
    public String intToRoman(int num) {
        String sol = "";
        while (num > 0) {
            if (num >= 1000) {
                sol += "M";
                num -= 1000;
            }
            else if (num >= 900) {
                sol += "CM";
                num -= 900;
            }
            else if (num >= 500) {
                sol += "D";
                num -= 500;
            }
            else if (num >= 400) {
                sol += "CD";
                num -= 400;
            }
            else if (num >= 100) {
                sol += "C";
                num -= 100;
            }
            else if (num >= 90) {
                sol += "XC";
                num -= 90;
            }
            else if (num >= 50) {
                sol += "L";
                num -= 50;
            }
            else if (num >= 40) {
                sol += "XL";
                num -= 40;
            }
            else if (num >= 10) {
                sol += "X";
                num -= 10;
            }
            else if (num >= 9) {
                sol += "IX";
                num -= 9;
            }
            else if (num >= 5) {
                sol += "V";
                num -= 5;
            }
            else if (num >= 4) {
                sol += "IV";
                num -= 4;
            }
            else {
                sol += "I";
                num -= 1;
            }
        }
        
        return sol;
    }
}