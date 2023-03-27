/**
 * Permutation in String
 * 
 * Top 86% (4ms)
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int[] count1 = new int[26];
       int[] count2 = new int[26];
       char[] c1 = s1.toCharArray();
       char[] c2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            count1[c1[i] - 'a']++;
        }
        int left = 0;
        int len = c1.length;
        for (int right = 0; right < c2.length; right++) {
            int rightChar = c2[right] - 'a';
            // take in any letter that is in the s1
            if (count1[rightChar] >= 1) {
                count2[rightChar]++;
                len--;
            }
            // reset case if the next letter is not in s1
            if (count1[rightChar] == 0) {
                while (left < right) {
                    int leftChar = c2[left] - 'a';
                    if (count1[leftChar] > 1) {
                        count2[leftChar] = 0;
                    }
                    left++;
                    
                }
                len = c1.length;
            }
            // remove extra letter case 
            while (count1[rightChar] > count2[rightChar]) {
                int leftChar = c2[left] - 'a';
                count1[leftChar]--;
                left++;
                len++;
            }
            System.out.println(left + " " + right);
            
            if (len == 0) {
                return true;
            }
        }
        return false;
    }
}