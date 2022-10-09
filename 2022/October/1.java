/**
 * Two Sum
 *
 * October 2022
 * Top 84% (4ms)  
 * 
 * Time complexity: O(n)
 * */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                int[] sol = new int[2];
                sol[0] = i;
                sol[1] = map.get(target - nums[i]);
                return sol;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}