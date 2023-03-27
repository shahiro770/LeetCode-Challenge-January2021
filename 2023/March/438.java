/**
 * Find All Anagrams in a String
 * 
 * Top 77% (7ms)
 * 
 * Extremely similar to 567, except instead of just checking if the string exists,
 * you need to find the starting index of all possible anagrams.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> sol = new ArrayList<Integer>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();
        int[] count1  = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < chars2.length; i++) {
            count1[chars2[i] - 'a']++;
        }

        int left = 0;
        int right = 0;
        int len = chars2.length;
        
        for (right = 0; right < chars1.length; right++) {
            count2[chars1[right] - 'a']++;

            // reset if we encounter a character not in p
            if (count1[chars1[right] - 'a'] == 0) {
                left = right + 1;
                count2 = new int[26];
                len = chars2.length;
            }
            // if the character is in p
            else if (count1[chars1[right] - 'a'] >= count2[chars1[right] - 'a']) {
                len--;
            }
            // move the left end of the window up until the extra letter is removed
            while (count1[chars1[right] - 'a'] < count2[chars1[right] - 'a']) {
                // if the char to be removed was not an extra, len goes up
                if (count1[chars1[left] - 'a'] >= count2[chars1[left] - 'a']) {
                    len++;
                }
                count2[chars1[left] - 'a']--;
                left++;
            }
            // solution found if all characters in p are accounted for
            if (len == 0) {
                sol.add(left);
                count2[chars1[left] - 'a']--;
                len++;
                left++;
            }
        }


        return sol;
    }
}