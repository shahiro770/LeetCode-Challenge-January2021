/**
 * Find Original Array from Doubled Array
 * 
 * September 2022
 * Top 74% (99ms)
 * 
 * Sort the list in ascending order an count the frequencies of each number.
 * Since the smallest values can't have their doubles occur before them, you only
 * need to verify if there are enough doubled values of them to confirm they were
 * part of the original list. 
 * 
 * Time complexity: O(nlogn) because sort
 */

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {  // if its odd length it can't be a doubled list
            return new int[0];
        }
        
        Arrays.sort(changed);
        HashMap<Integer, Integer> doubleMap = new HashMap<Integer, Integer>();
        
        // count the frequencies
        for (int i = 0; i < changed.length; i++) {
            doubleMap.put(changed[i], doubleMap.getOrDefault(changed[i], 0) + 1);
        }
        int[] original = new int[changed.length / 2];
        int originalIndex = 0;
        
        /*
         * The 0 case is tricky and dealt with first. Since 0 double is 0,
         * it breaks the logic below. Just check if there's an even number of zeroes
         * and add them to the list accordingly.
         */
        if (doubleMap.containsKey(0) && doubleMap.get(0) % 2 == 0) {   
            for (int i = 0; i < doubleMap.get(0) / 2; i++) {
                original[originalIndex++] = 0;
            }
            doubleMap.put(0, 0);   
        }
        else if (doubleMap.containsKey(0) && doubleMap.get(0) % 2 == 1) {   
            return new int[0];
        }
        
        for (int i = 0; i < changed.length; i++) {
            if (i > 0 && changed[i] == changed[i - 1]) {
                continue;
            }
            int doubled = changed[i] * 2;
            int singleOccurrences = doubleMap.get(changed[i]);
            int doubledOccurrences = doubleMap.getOrDefault(doubled, 0);
            
            // there must be enough doubleOccurrences to satisfy the single of the number we are looking at
            // otherwise return an empty list
            if (singleOccurrences > doubledOccurrences) {
                return new int[0];
            }
            else {
                for (int j = 0; j < singleOccurrences; j++) {
                     original[originalIndex++] = changed[i];
                }
                
                doubleMap.put(doubled, doubledOccurrences - singleOccurrences);
            }
        }
        
        return original;
    }
}

/*
[1,3,4,2,6,8]
[6,3,0,1]
[1]
[0,0,0,0]
[32,8,16,4]
[0,3,2,4,6,0]
*/