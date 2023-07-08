/*
 * Put Marbles in Bags
 *
 * Top 97% (37ms)
 * 
 * The easier part of understanding this problem is that for n marbles, we can have n -1 divisions.
 * With each division between marbles i and i+ 1, you can to the score weights[i] + weights[i + 1]
 *      E.g. if we have marbles[0,1,2,3,4,5], with k = 1, we have (0 + 5 ) = 5
 *          With k = 2, a possible division [0,1,2,|3,4,5], we have 0 + (2 + 3) + 5, although intuitively it looks like (0 + 2) + (3 + 5)
 *          Notice as a consequence of this, for any marble distribution score, the minimum value is weights[0] + weights[n - 1]
 * The tricky part is understanding how to use this fact to get the solution
 *      Say we precomputed the values of all n-1 divisions
 *          The maximum distribution will use the k-1 most valuable partitions
 *          The minimum distribution will use the k-1 least valuable partitions
 *              The solution will be the difference between these two distributions
 *      Notice how we don't bother dealing with weights[0] + weights[n - 1]
 *          They get cancelled out as their values are in both the min and max distributions
 * 
 * Time Complexity: O(nlogn)
 */

class Solution {
    public long putMarbles(int[] weights, int k) {
        long min = 0;
        long max = 0;

        int[] costs = new int[weights.length - 1];  // for n marbles, we can have n - 1 divisions
        for (int i = 0; i < weights.length - 1; i++) {
            costs[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(costs);

        /*
         * The maximum distribution will use the k partitions from the front
         * The minimum distribution will use the k partitions from the end
         */
        for (int i = 0; i < k - 1; i++) {
            min += costs[i];
            max += costs[costs.length - 1 - i];
        }

        return max - min;
    }
}

/*
    [1,|2,3,4,5,6,7,8,|9]
    2 + 10 + 18 = 30
    [1,2,|3,4,5,6,7,|8,9]
    3 + 10 + 17 = 30

    [1,2,|3,4,5,6,7,|8,9]
    Cost = (0 + 7) + (8 + 9) = 24
    Cost = (0 + 2) + (3 + 7) + (8 + 9)

*/