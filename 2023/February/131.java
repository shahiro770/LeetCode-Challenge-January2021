/**
 * Palindrome Partitioning
 *
 * Top 99% (8ms)
 * 
 * Easy back tracking problem since your end clause is just if you've managed to reach the end and
 * you only follow a "decision tree path" if the current consumed substring is a palindrome.
 * 
 * Time Complexity: O(2^n) I think
 */

class Solution {
    ArrayList<List<String>> sol;
    ArrayList<String> partition;

    public List<List<String>> partition(String s) {
        sol = new ArrayList<>();
        partition = new ArrayList<String>();

        backTrack(0, s);

        return sol;
    }

    public void backTrack(int pos, String s) {
        if (pos == s.length()) {
            sol.add(new ArrayList<String>(partition));
        }
        else {
            // try each of the possible substrings from the current spot
            // any valid palindromes warrant repeating the process from the character immediately after
            for (int i = pos + 1; i <= s.length(); i++) {
                String subString = s.substring(pos, i);
                if (isPalindrome(subString)) {
                    partition.add(subString);
                    backTrack(i, s);
                    partition.remove(partition.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}