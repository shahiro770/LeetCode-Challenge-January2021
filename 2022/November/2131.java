/**
 * Longest Palindrome by Concatenating Two Letter Words
 *
 * Top 81% (61ms)
 * 
 * Realize that you don't actually have to build any palindromes manually. Rather see 
 * how many of each 2 character string is available and how many pairs they have.
 * The only complexity arises when having to handle the mirror strings (i.e "aa").
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // first get a count of each string
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        int maxLength = 0;
        /*
            In the event we get an odd number of mirror strings, we can only use the first odd one.
            If we had 3 "aa", we can form "aaaaaa" as a palindrome since the middle string of the palindrome
            can be a mirror
            But if we had 3 "aa" and 3 "bb", it isn't possible. However, we can still take
            an even quantity from other mirror strings (i.e. we'd get "bbaaaaaabb").
        */ 
        boolean singularOddDouble = false;

        for (HashMap.Entry<String, Integer> e : map.entrySet()) {
            String reverse = new StringBuilder(e.getKey()).reverse().toString();

            //  mirror case
            if (e.getKey().equals(reverse)) {
                // case 1: even quantity of mirrors
                if (e.getValue() % 2 == 0) {
                    maxLength += e.getValue() * 2;
                }
                // case 2: odd quantity of mirrors but we haven't used an odd quantity yet
                else if (e.getValue() % 2 == 1 && singularOddDouble == false) {
                    maxLength += e.getValue() * 2;
                    singularOddDouble = true;
                }
                // case 3: odd quanttiy of mirrors and we already have used one, so just take all except 1
                else if (e.getValue() > 1 && singularOddDouble == true) {
                    maxLength += (e.getValue() - 1) * 2;
                }
            }
            // reverse case
            else if (map.containsKey(reverse)) {
                int reverseCount = map.get(reverse);
                int pairCount = Math.min(e.getValue(), reverseCount);
                maxLength += pairCount * 2;
            }
        }

        return maxLength;
    }
}