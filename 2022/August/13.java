/*
 * Roman to Integer
 * 
 * Top 10% (25ms)
 *
 * Its just a matter of optimizing how you check the characters/store them.
 * Better solution at the bottom
 *
 * Time complexity: O(n) where n is the number of characters
*/

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        
        char[] romanChars = s.toCharArray();
        String curr = "";
        
        for (int i = 0; i < romanChars.length; i++) {
            curr += romanChars[i];
            
            if (i < romanChars.length - 1) {
                if (curr.equals("C")) {
                    if (romanChars[i + 1] == 'M' || romanChars[i + 1] == 'D') {
                        curr += romanChars[i + 1];
                        i++;
                    }
                }
                else if (curr.equals("X")) {
                    if (romanChars[i + 1] == 'C' || romanChars[i + 1] == 'L') {
                        curr += romanChars[i + 1];
                        i++;
                    }
                }
                else if (curr.equals("I")) {
                    if (romanChars[i + 1] == 'X' || romanChars[i + 1] == 'V') {
                        curr += romanChars[i + 1];
                        i++;
                    }
                }
            }
            
            switch (curr) {
                case "M":
                    ans += 1000;
                    curr = "";
                    break;
                case "CM":
                    ans += 900;
                    curr = "";
                    break;
                case "D":
                    ans += 500;
                    curr = "";
                    break;
                case "CD":
                    ans += 400;
                    curr = "";
                    break;
                case "C":
                    ans += 100;
                    curr = "";
                    break;
                case "XC":
                    ans += 90;
                    curr = "";
                    break;
                case "L":
                    ans += 50;
                    curr = "";
                    break;
                case "XL":
                    ans += 40;
                    curr = "";
                    break;
                case "X":
                    ans += 10;
                    curr = "";
                    break;
                case "IX":
                    ans += 9;
                    curr = "";
                    break;
                case "V":
                    ans += 5;
                    curr = "";
                    break;
                case "IV":
                    ans += 4;
                    curr = "";
                    break;
                default:
                    ans += 1;
            }
        }
        
        return ans;
    }
}

/*
sample 5 ms submission
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case 'I' :
                    sum += 1;
                    break;
                case 'V' :
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'I')
                        sum += 3;
                    else
                        sum += 5;
                    break;
                case 'X' :
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'I')
                        sum += 8;
                    else
                        sum += 10;
                    break;
                case 'L' :
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'X')
                        sum += 30;
                    else 
                        sum += 50;
                    break;
                case 'C' :
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'X')
                        sum += 80;
                    else
                        sum += 100;
                    break;
                case 'D' :
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'C')
                        sum += 300;
                    else 
                        sum += 500;
                    break;
                case 'M' :
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'C')
                        sum += 800;
                    else
                        sum += 1000;
                    break;
            }   
        }
        
        return sum;
    }
}
*/