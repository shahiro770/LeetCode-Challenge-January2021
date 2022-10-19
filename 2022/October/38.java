/**
 * Count and Say
 * 
 * Top 93% (3ms)
 * 
 * Weirdo question
 * 
 * Time Complexity: O(nk)
 * */

class Solution {
    public String countAndSay(int n) {   
        String curr = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] currChar = curr.toCharArray();
            int count = 0;
            char c = currChar[0];
            for (int j = 0 ; j < currChar.length; j++) {
                if (c == currChar[j]) {
                    count++;
                }
                else if (c != currChar[j]) {
                    sb.append(count);
                    sb.append(c);
                    count = 1;
                    c = currChar[j];
                }
            }
            sb.append(count);
            sb.append(c);
            curr = sb.toString();
        }

        return curr;
    }
}