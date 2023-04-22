/*
 * Summary Ranges
 * 
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n) 
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> sol = new ArrayList<String>();
        Integer start = null;
        Integer end = null;
        for (int i = 0; i < nums.length; i++) {
            if (start == null) {
                start = nums[i];
            }
            else if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            }
            else {
                StringBuilder sb = new StringBuilder();
                if (end == null) {
                    sb.append(start);
                    sol.add(sb.toString());
                }
                else {
                    sb.append(start);
                    sb.append("->");
                    sb.append(end);
                    sol.add(sb.toString());
                }
                start = nums[i];
                end = null;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (end == null && start != null) {
            sb.append(start);
            sol.add(sb.toString());
        }
        else if (start != null) {
            sb.append(start);
            sb.append("->");
            sb.append(end);
            sol.add(sb.toString());
        }
        return sol;
    }
}