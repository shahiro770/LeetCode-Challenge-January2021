/**
 * Majority Element
 * 
 * While you will always get an O(n) solution by just doing a simple count, there's actually
 * a billion iq solution involving something known as the boyer-moore voting algorithm
 * that uses O(1) space:
 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
 *
 * Time complexity: O(n)
 */

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int instances = hash.containsKey(nums[i]) ? hash.get(nums[i]) : 0;
            hash.put(nums[i], instances + 1);    
            if (instances + 1 > nums.length / 2) {
                return nums[i];
            }
        }

        return 0;
    }
}