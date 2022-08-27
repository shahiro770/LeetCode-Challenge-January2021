/**
 * Longest Increasing Subsequence
 * Aug 2022 Day 9
 * Top 89% (31ms)
 * 
 * DP all days 
 * 
 * 1) Sort the list, since as we know for a fact the smallest element has no factors, and
 * then the next element can only have elements prior as factors (if possible). Bottom up solution.
 * 2) If arr[i] is divisible by arr[j] and arr[j] and arr[i]/arr[j] are both in the hashmap,
 * add the number of trees for arr[j] * the number of trees for arr[i]/arr[j]
 *      The combination maths (you have n options for the first branch,and m options for the second branch)
 * 3) Add the number of trees to the sum 
 * 
 * Time complexity: O(n^2)
 */

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long total = 0;
        
        Arrays.sort(arr);

        int mod = (int)(Math.pow(10, 9) + 7);
        long count;
        
        HashMap<Integer, Long> dp = new HashMap<Integer, Long>();

        for (int i = 0; i < arr.length; i++) {
            count = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[i] % arr[j] == 0 && dp.containsKey(arr[j]) && dp.containsKey(arr[i]/arr[j]) {
                   count = (count + dp.get(arr[i]/arr[j]) * dp.get(arr[j])) % mod;
                }
            }
                    
            dp.put(arr[i], count);
            total = (total + count) % mod;
        }
        
        System.out.println(dp);
        
        return (int) total;
    }
}