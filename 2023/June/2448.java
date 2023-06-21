/*
 * Minimum Cost to Make Array Equal
 *
 * Top 92% (16ms)
 * 
 * Spent 2 hours timing out on this before I copied lee215's solution so i have no honour.
 * https://leetcode.com/problems/minimum-cost-to-make-array-equal/solutions/2734162/java-c-python-binary-search/
 * 
 * Due to the fact that the totalCost is a convex function (increasing from one side, decreasing from the other, to a single point)
 *      Proof: https://leetcode.com/problems/minimum-cost-to-make-array-equal/solutions/2734728/pure-math-based-explanation-of-why-cost-function-is-convex/
 * You can binary search for this minCost by testing it and its neighbour (cause that tells us if the cost is increasing/decreasing
 * from the given point). This process of taking two "mids" is called a ternary search.
 * 
 * The more practical answer to this one is DP but I couldn't get it to work
 * 
 * Time Complexity: O(nlogn)
 */

class Solution {
    public long minCost(int[] nums, int[] cost) {
        /*
         * Our left/right will be the min/max of the nums array, as that
         * the smallest difference will be inbetween those numbers
         * 
         */
        long left = Integer.MAX_VALUE;
        long right = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            left = Math.min(nums[i], left);
            right = Math.max(nums[i], right);
        }
        long ans = findCost(nums, cost, left);  // if left == right, the search below won't execute and cost = 0

        /*
         * Binary search for the optimal difference
         */
        while (left < right) {
            long mid = left + (right - left) / 2;
            long y1 = findCost(nums, cost, mid);
            long y2 = findCost(nums, cost, mid + 1);

            ans = Math.min(y1,y2);
            if (y1 < y2) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }


        return ans;
    }

    private long findCost(int[] nums, int[] cost, long x) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - x) * cost[i];
        }
        return res;
    }
}