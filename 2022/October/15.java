/*
 * 3Sum
 * 
 * August 2022
 * Top 66% (33ms)
 *
 * This problem is annoying because you need to avoid duplicate solutions.
 * The way to do this is to move to the next starting number whenever the current one
 * is the same as the previous, as well as moving the left pointer over for similar logic
 * after providing a solution.
 *
 * Time complexity: O(n^2) 
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> newSol = new ArrayList<Integer>();
                    newSol.add(nums[i]);
                    newSol.add(nums[left]);
                    newSol.add(nums[right]);
                    sol.add(newSol);
                    left += 1;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
                if (sum > 0) {
                    right--;
                }
                else if (sum < 0){
                    left++;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
        
        }

        return sol;
    }
}