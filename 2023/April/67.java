/*
 * Add Binary
 * 
 * Top 45% (2ms)
 * 
 * We don't talk about this one. Faster solution 
 * 
 * Time complexity: O(n)
 */

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (b.length() > a.length()) {
            return addBinary(b, a);
        }

        a = reverse(a);
        b = reverse(b);

        boolean carryOver = false;

        for (int i = 0; i < b.length(); i++) {
            if (carryOver == false) {
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    sb.append("0");
                    carryOver = true;
                }
                else if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                    sb.append(1);
                }
                else {
                    sb.append(0);
                }
            }
            else {
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    sb.append("1");
                    carryOver = true;
                }
                else if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                    sb.append(0);
                }
                else {
                    sb.append(1);
                    carryOver = false;
                }
            }
        }

        for (int i = b.length(); i < a.length(); i++) {
            if (carryOver == true) {
                if (a.charAt(i) == '1') {
                    sb.append("0");
                }
                else {
                    sb.append("1");
                    carryOver = false;
                }
            }
            else {
                sb.append(a.charAt(i));
            }
        }

        if (carryOver == true) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    private String reverse(String s) {
        char[] reversal = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            reversal[s.length() - 1 - i] = s.charAt(i);
        }

        return new String(reversal);
    }
}