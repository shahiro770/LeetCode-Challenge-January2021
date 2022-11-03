/**
 * Maximum Length of a Concatenated String with Unique Characters
 * 
 * Top 76% (18ms)
 * 
 * Need to use bit manipulation to make this efficient
 * The backtracking is just retrying all strings each time you add a new one
 * since you have no idea if a new string in the array can combo longer with a previous one
 * rather than the current best.
 * 
 * Time Complexity: O(n * n) I think? If concat list = unique list
 * */

class Solution {
    public int maxLength(List<String> arr) {
        int max_len = 0;
        
        // First throw away all strings with any duplicate characters
        // Encode it into a binary value (26 bits, one per letter)
        List<Integer> unique = new ArrayList<Integer>();
        for (String s : arr) {
            Integer bin = 0;
            for (char ch : s.toCharArray()) {
                bin += 1 << (ch - 'a');
            }
            // bitCount counts the number of set bits (1s)
            // if the bitCount is equal to the length, we had no duplicates
            if (Integer.bitCount(bin) == s.length()) {
                unique.add(bin);
            }
        }

        // Now start with an empty concatenation and iteratively 
        // initialize the list with 0
        ArrayList<Integer> concat = new ArrayList<Integer>(List.of(0));
        for (Integer u : unique)
            for (int i = concat.size() - 1; i >= 0; i--)
                // if there's no overlap in the bits (ie no shared characters)
                // add the string to the list of concatenations done
                // The "backtracking" part of the algorithm is re-testing
                // individual concatenations with each new string to see if it might give a longer string
                if ((concat.get(i) & u) == 0) {
                    Integer cc = concat.get(i) | u;
                    concat.add(cc);
                    max_len = Math.max(max_len, Integer.bitCount(cc));
                }

        return max_len;
    }
}