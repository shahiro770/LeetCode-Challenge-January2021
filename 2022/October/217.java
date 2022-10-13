/**
 * Contains Duplicate
 *
 * October 2022
 * Top 98% (5ms)  
 * 
 * Time complexity: O(n) since hashsets use a hashmap as its underlying structure.
 * */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> counts = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (counts.contains(nums[i])) {
                return true;
            }
            counts.add(nums[i]);
        }
        return false;
    }
}