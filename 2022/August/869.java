/**
 * Reordered Power of 2
 * 
 * August 2022
 * Top 68% (2ms)
 * 
 * 
 * The idea is simple:
 * 1) Count the frequency of digits for the number
 * 2) Count the frequency of digits for each power of 2
 * 3) Compare these frequencies at each stage
 * 
 * You can do a manual count and compare (Arrays.equals() is really fast) or leave it as a string
 * and do s1.equals(s2).
 */ 

class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] a1 = String.valueOf(n).toCharArray();
        Arrays.sort(a1);
        
        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf((int)(1 << i)).toCharArray();
            Arrays.sort(a2);
            if (Arrays.equals(a1, a2)) {
                return true;  
            } 
        }
        return false;
    }
}