/*
 * Delete Columns to Make Sorted
 * 
 * Top 99% (1ms)
 * 
 * If the previous letter isn't a capital and the current one is, return false.
 * If the previous letter is a capital and the current one isn't and its not the start of a word, return false.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int minDeletionSize(String[] strs) {
        int dels = 0;
        
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    dels++;
                    break;
                }
            }
        }

        return dels;
    }
}