/*
 * Max Sum of Rectangle No Larger Than K
 * 
 * August 2022
 * Top 28% (752ms) aka trash
 *
 * I had to look at someone else's solution after I got the 2d kadane working with the upper bound treeset.
 * So here's the logic I did understand:
 * 1) You can do a 2d kadane's algorithm to get a max subarray in a 2d space
 * 2) A treeset is used to find the closest upper bound amid the sums from the 2d spaces you've calculated
 * to which the value doesn't exceed k (or if in the case there are none, set.ceiling() returns null)
 * 
 * What I don't understand:
 * 3) What is the sum math going on?!??!
 *
 * Time complexity: Don't want to think about it
*/

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int left = 0;
        int right = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        while (left < matrix[0].length) {
            int[] sums = new int[matrix.length];
            right = left;
            while (right < matrix[0].length) {
                for(int i = 0; i < matrix.length; i++){
                    sums[i] += matrix[i][right];
                }
                
                //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
                TreeSet<Integer> set = new TreeSet<Integer>();
                //add 0 to cover the single row case
                set.add(0);
                int currSum = 0;
                
                for(int i = 0; i < sums.length; i++) {
                    currSum += sums[i];
                    //we use sum subtraction (currSum - sum) to get the subarray with sum <= k
                    //therefore we need to look for the smallest sum >= currSum - k
                    Integer num = set.ceiling(currSum - k);
                    if (num != null) {
                        maxSoFar = Math.max(maxSoFar, currSum - num );
                    }
                    set.add(currSum);
                }
                
                right++;
            }
            left++;
        }
        
        return maxSoFar;
    }
}

/*
[[1,0,1],[0,-2,3]]
2
[[2,2,-1]]
3
[[-1,-3,-1],[-13,-2,3]]
0
*/