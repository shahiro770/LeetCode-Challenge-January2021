/**
 * May 2021 Day 8
 * Top 92%
 * 
 * Dumb question. So first off you need to find a way to restrict the problem domain and find a pattern cause testing all 10^18 numbers will time you out.
 * 
 * Since any number with x digits times itself can only produce a number with 2x digits at most, we only need to test
 * numbers from 1 to 99999999, since by definition their squares will need to be palindromes to be considered superpalindromes
 * 
 * Try printing out all the super palindromes from 1 to 99999999. 
 *      Before you time out you'll see that some of the pre square values are 1, 2, 3, 11, 22, 101, 121, 202, ...
 *          Pattern: The presquare value must consist of the digits 0, 1 or 2, (with the exception of 3, so we can test this edge case at the start)
 * 
 * Strategy becomes testing all numbers in base 3 who's literal values are between 1 and 99999999
 *      By some miracle the range of numbers is from 1 to 10^18, JUST under the size of a long, otherwise you need to use Java BigInteger 
 *          Or square strings by hand in a loop with some really tiresome manipulations.
 *      Largest base 3 number who's literal value is in range is 222222222 (so we stop at 1000000000)
 *             222222222 in base 10 3^9
 * Time complexity is O(3^9) (worst case it can only go for 3^9)
 */

class SuperPalindrome {
    public int superpalindromesInRange(String left, String right) {
        int sols = 0;
        
        long longLeft = Long.parseLong(left);
        long longRight = Long.parseLong(right);
        
        if (longLeft <= 9 && longRight >= 9) {
            sols++;
        }
        
        // get the max of the largest square root in base 3
        StringBuilder sb = new StringBuilder();
        String curr;
        sb.append("1");
        
        while(sb.toString().equals("1000000000") == false) {
            curr = sb.toString();
            if (isPalindrome(curr)) {
                long currLong = Long.parseLong(curr);
                long squareCurrLong = currLong * currLong;
                String squareCurrLongStr = Long.toString(squareCurrLong);
                if (isPalindrome(squareCurrLongStr) && squareCurrLong >= longLeft && squareCurrLong <= longRight) {
                    sols++;
                }
                if (squareCurrLong > longRight) {
                    break;
                }
            }
            
            sb = getNextBase3(sb);
        }

        return sols;    
    }
    
    public StringBuilder getNextBase3(StringBuilder num) {
        int carry = 1;
        int index = 0;
        
        while (carry == 1) {
            if (index == num.length()) {
                num.insert(0, '1');
                carry = 0;
            }
            else if (num.charAt(index) == '0') {
                num.setCharAt(index, '1');
                carry = 0;
            }
            else if (num.charAt(index) == '1') {
                num.setCharAt(index, '2');
                carry = 0;
            }      
            else {
                num.setCharAt(index, '0');
                index++;
            }
        }
        
        return num;
    }
    
    public boolean isPalindrome(String num) {
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }
        
        return true;
    } 
}