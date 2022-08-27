/**
 * Ransom Note
 * 
 * August 2022
 * Top 68% (6ms)
 * 
 */ 

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
            letters[(int)(magazine.charAt(i) -'a')]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = (int)(ransomNote.charAt(i) -'a');
            letters[index]--;
            if (letters[index] == -1) {
                return false;
            }
        }
        return true;
    }
}