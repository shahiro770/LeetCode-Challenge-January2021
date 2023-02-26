/*
 * Non-decreasing Subsequences
 *
 * Top 99% (3ms) 
 * 
 * I honestly don't know why this is called back tracking, really just feels like you go forward in a decision
 * tree but whatever. As you go forward in the nums array, you havae two options:
 *      1) Take the num and move to the next one
 *      2) Leave the num and move to the next one
 * Any valid subsequence must be non-decreasing, and have more than 2 elements. What this means:
 *      3) Default to 2) if the observed element is less than the last element in the subsequence
 *      4) Once we reach the end, whatever sequence we have can be thrown out if it doens't have 2 or more elements
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        ArrayList<Integer> subs = new ArrayList<Integer>();
    
        fowardTrack(nums, 0, Integer.MIN_VALUE, subs, sol);

        return sol;
    }

    public void fowardTrack(int[] nums, int pos, int prev, ArrayList<Integer> subs, ArrayList<List<Integer>> sol) {
        if (pos == nums.length && subs.size() >= 2) {
            sol.add(new ArrayList(subs));
        }
        else if (pos < nums.length){
            // only take elements that leave us with a non-decreasing sequence
            if (nums[pos] >= prev) {
                // to save on space and time, we add and then remove the element after we're done its decision tree
                // path, kind of like a DFS
                subs.add(nums[pos]);
                fowardTrack(nums, pos + 1, nums[pos], subs, sol);
                subs.remove(subs.size() - 1);
            }
            /**
             * After testing the current element, we only proceed with a sequence without it IF the current element 
             * doesn't already match the previous number. Why? Suppose we had the sequence {1} and the current observed number
             * is also a 1
             *  1) If we take the current 1, the sequence {1, 1} was already covered in the above test, which results in a repeat
             *  2) If we don't take the current 1, the sequence {1} will be tested with other numbers in the array
             */ 
            if (nums[pos] != prev){
                fowardTrack(nums, pos + 1, prev, subs, sol);
            }
        }
    }
}
