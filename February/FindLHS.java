
/**
 * Feb 2021 Day 4
 * Store how often each number appears in a hashmap
 * Then iterate through the map
 *      If for a given entry, the entry at the key + 1 exists, then sum that and the current entry's values
 *          If that sum is the larger than the largest, update the largest count
 *      This works since the least harmonic subsequence is basically the entire array removing any elements outside of the current interval
 *          1,2,3,2,4 
 * O(n) for time and space
 */

class FindLHS {
    public int findLHS(int[] nums) {
        int bestCount = 0;
        
        Map<Integer,Integer> freqs = new HashMap<Integer,Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            freqs.put(nums[i], freqs.getOrDefault(nums[i], 0) + 1);
        }
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            if (freqs.containsKey(entry.getKey() + 1)) {    // contains key is infinitely faster than using get() and checking for null (literally shot me from 20% to 90%)
                count = entry.getValue() + freqs.get(entry.getKey() + 1);   // only need to check + 1 to test all possible intervals (don't need to test down since its redundant)
                if (count > bestCount) {
                    bestCount = count;
                }
            }
        }

        return bestCount;
    }
}