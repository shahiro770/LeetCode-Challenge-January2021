/**
 * Longest Consecutive Sequence
 *
 * October 2022
 * Top 93% (21ms)  
 * 
 * Convert the array to a set (or a map) to make checking elements existing an O(1) operation.
 * From there if an element can be said to be a start of a sequence (i.e element - 1 is not in the set)
 * start looping to see if element +1, +2, +3,... is in the set, which builds the sequence.
 * 
 * Time complexity: O(n)
 * */

class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Iterator<Integer> it = set.iterator(); 

        for (Integer e : set) { 
             if (set.contains(e - 1) == false) {
                 int val = e;
                 int count = 1;
                 longest = Math.max(longest, count);
                 val++;
                 while (set.contains(val)) {
                     longest = Math.max(longest, ++count);
                     val++;
                 }
             }
        } 

        return longest;
    }
}

/*
1
2
4
3
*/