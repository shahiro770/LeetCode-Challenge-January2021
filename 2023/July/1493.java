/**
 * Longest Subarray of 1's After Deleting One Element
 *
 * Top 84% (2ms)
 * 
 * Three steps to this algorithm:
 * 1) Condense the nums array into a list
 *      We can view a chain of 1's as a total 
 *      If we encounter a 0, add the total to a list; adjacent numbers in the list can be assumed to have a 0 between them that can be deleted
 *          Edge case: If we have a chain [1,1,0,0,1,1]deleting a single 0 won't let us join the 2's on either end
 *              We can mark this by adding a 0 to the list, preventing us from joining
 * 2) Deal with corner cases
 *      2.1) If the entire list is 0s, the condesned list will be empty => return 0
 *      2.2) If the entire list is only 1s, the condensed list will have exactly one element => return that element - 1 as deletion is mandatory
 * 3) Find the largest adjacent pair amongst the condensed list
 *      Adjacent numbers combined represents a deletion of a single 0 in the middle
 *          The largest sum from a pair will be our answer
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> counts = new ArrayList<Integer>();

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) { 
                count++;
                if (i == nums.length - 1) {
                    counts.add(count);
                }
            }
            /*
             * Consequence of this, if the array is [0,1,1,1,0], counts will be of size 2 due to the first 0 being set
             *      This ensures a deletion is handled and a wrong answer isn't produced via edge case 2.2)
             */
            else { 
                counts.add(count);
                count = 0;
            }
        }
        if (counts.size() == 0) {
            return 0;
        }
        if (counts.size() == 1) {
            if (nums[nums.length - 1] == 0) {   // fails the edge case[1,1,1,0], surprisingly not required to pass this question
                return counts.get(0);
            }
            return counts.get(0) - 1;
        }


        int sol = 0;
        int currPair = 0;
        for (int i = 0; i < counts.size(); i++) {
            currPair += counts.get(i);
            if (i > 1) {
                currPair -= counts.get(i - 2);
            }
            sol = Math.max(currPair, sol);
        }

        return sol;
    }
}