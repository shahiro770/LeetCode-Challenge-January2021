/**
 * Pseudo-Palindromic Paths in a Binary Tree
 * 
 * September 2022
 * Top 99% (4ms)
 *
 * Apply the queries, and update the even sum after each one.
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] output = new int[queries.length];
        int evenSum = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if ((nums[i] & 1) == 0) {
                evenSum += nums[i];
            }
        }
            
        for (int i = 0; i < queries.length; i++) {
            int prevNum = nums[queries[i][1]];     
            int newNum = prevNum + queries[i][0];  
            boolean wasEven = (prevNum & 1) == 0;        
            
            if (wasEven == true && Math.abs(newNum % 2) == 1) {
                evenSum -= prevNum;
            }
            else if (wasEven == false && Math.abs(newNum % 2) == 0) {
                evenSum += newNum; 
            }
            else if (wasEven == true && newNum % 2 == 0) {
                evenSum += newNum - prevNum;
            }
            
            nums[queries[i][1]] = newNum;
            output[i] = evenSum;
        }
        
        return output;
    }
}