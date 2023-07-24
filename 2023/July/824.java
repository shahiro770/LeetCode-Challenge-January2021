/*
 * Goat Latin
 *
 * Top 62% (4ms)
 * 
 * Faster solution is to do this with string.split() so you don't waste time checking spaces, but w/e
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder a = new StringBuilder();
        a.append("a");
        StringBuilder sol = new StringBuilder();
        boolean isWord = true;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                char firstLetter = Character.toLowerCase(sentence.charAt(i));
                char firstLetterNorm = sentence.charAt(i);
                if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u') {
                    while (i < sentence.length() && sentence.charAt(i) != ' ') {
                        sol.append(sentence.charAt(i));
                        i++;
                    }
                    sol.append("ma");
                }
                else {
                    i++;
                    while (i < sentence.length() && sentence.charAt(i) != ' ') {
                        sol.append(sentence.charAt(i));
                        i++;
                    }
                    sol.append(firstLetterNorm + "ma");
                }
                sol.append(a);
                a.append("a");
                if (i < sentence.length()) {
                    sol.append(" ");
                }
            }
            else {
                sol.append(" ");
            }
        }

        return sol.toString();
    }


}