/*
 * Determine if Two Strings Are Close
 * 
 * Top 88% (14ms)
 * 
 * This problem reduces to two steps:
 * 
 * 1) See if the letter exists in both strings
 *      If it doesn't, closeness is impossible due to the requirement of a character existing in order to transform
 * 
 * 2) Sort the strings and see if both an equal number of characters of the same quantity
 *      If word1 has 1 b 5 a and word2 has 5 a and 1 b, we can transform word1 into word2
 *      If word1 2 of a,b and word2 has 1 a and 3 b, we can't possibly transform word1 into word2
 *      In other words, we need both strings to have exactly the same number of letters with the same 
 *      frequncies for the transformation to be possible.
 * 
 * Time Complexity: O(n). It looks O(nlgn) but the sorting time does not depend on the input.
 */

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++; 
        }
        for (int i = 0; i < word2.length(); i++) {
            count2[word2.charAt(i) - 'a']++; 
        }

        for (int i = 0; i < count1.length; i++) {
            if ((count1[i] > 0 && count2[i] == 0) || (count2[i] > 0 && count2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        for (int i = 0; i < count2.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}

/*
a
*/