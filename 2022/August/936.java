/**
 * Stamping The Sequence
 * 
 * August 2022
 * Top 98% (4ms)
 * 
 * Do the problem in reverse since its easier to model.
 * See where you can take a stamp out from (treating '?' as a wild card) until you can
 * get a string of question marks.
 * 
 * Time complexity: O((n - m)^2 * m) where n is the length of target and m is the length of the stamp.
 * In the worst case scenario we have to run the check and replacement logic on every single n-m characters
 */ 

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] tchar = target.toCharArray();
        char[] schar = stamp.toCharArray();
        int changedCount = 0;  
        boolean[] visited = new boolean[target.length()];
        ArrayList<Integer> stamps = new ArrayList<Integer>();
        
        // we are done once we've changed every character in the target string
        while (changedCount != target.length()) {
            boolean didReplace = false;
            
            // don't bother checking the characters past where we can start to put our stamp
            for (int i = 0; i <= tchar.length - schar.length; i++) {
                if (visited[i] == false && canReplace(schar, tchar, i)) {
                    changedCount += stampReplace(schar, tchar, i);
                    visited[i] = true;  // don't try to change on an index we've already changed on
                    didReplace = true;
                    stamps.add(i);
                }
            }
            if (changedCount == target.length()) {
                break;
            }
            // if we couldn't replace anything and the strings still aren't the same it isn't possible
            if (didReplace == false) {
                return new int[0]; 
            }
        }
        
        int[] sol = new int[stamps.size()] ;
        for (int i = 0; i < stamps.size(); i++) {
            sol[stamps.size() - i - 1] = stamps.get(i);
        }
        return sol;
    }
    
    // Replace and output the number of characters that have been changed
    private int stampReplace(char[] schar, char[] tchar, int startIndex) {
        int changedCount = 0;
        for (int i = 0; i < schar.length; i++) {
            if (tchar[i + startIndex] != '?') {
                tchar[i + startIndex] = '?';
                changedCount++;
            }
        }
        
        return changedCount;
    }
    
    // See if we can replace, assumes we won't be checking out of bounds
    private boolean canReplace(char[] schar, char[] tchar, int startIndex) {
        for (int i = 0; i < schar.length; i++) {
            if (schar[i] != tchar[i + startIndex] && tchar[startIndex + i] != '?') {
                return false;
            }
        }
        
        return true;
    }
}