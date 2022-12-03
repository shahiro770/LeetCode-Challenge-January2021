/**
 * Sort Characters By Frequency
 * 
 * Top 98% (9ms)
 * 
 * Hacky solution since its made around the constraints:
 * 1) Make an array of 62 characters, holding all the lower, upper, and numbers
 * 2) Do a frequency count on the string
 * 3) Sort the frequency array in decreasing order
 * 4) Build the string by iterating over the frequency array
 * 
 * Time Complexity: O(n) because the sort is always 62log62
 */

class Solution {
    public String frequencySort(String s) {
        int[][] count = new int[62][2];
        for (int i = 0; i < 26; i++) {
            count[i][1] = 'A' + i;
        }
        for (int i = 26; i < 52; i++) {
            count[i][1] = 'a' + i - 26;
        }
        for (int i = 52; i < 62; i++) {
            count[i][1] = '0' + i - 52;
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count[s.charAt(i) - 'A'][0]++;
            }
            else if (Character.isLowerCase(s.charAt(i))){
                count[s.charAt(i) - 'a' + 26][0]++;
            }
            else {
                count[s.charAt(i) - '0' + 52][0]++;
            }
        }

        Arrays.sort(count, (a, b) -> {
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = count.length - 1; i >= 0; i--) {
            for (int j = 0; j < count[i][0]; j++) {
                sb.append((char)count[i][1]);
            }
        }
        
        return sb.toString();
    }
}