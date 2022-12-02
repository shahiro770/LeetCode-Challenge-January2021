/**
 * Unique Number of Occurrences
 * 
 * Top 99% (1ms)
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
           freqs.put(arr[i], freqs.getOrDefault(arr[i], 0) + 1);
        }

        // if the whole array is the same value, freqCount[freqCount.length] will go out of range
        // hence the +1
        int[] freqCounts = new int[arr.length + 1];

        for (Map.Entry<Integer, Integer> e : freqs.entrySet()) {
            freqCounts[e.getValue()]++;
            if (freqCounts[e.getValue()] == 2) {
                return false;
            }
        }

        return true;
    }
}