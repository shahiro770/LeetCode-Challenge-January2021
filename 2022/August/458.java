/**
 * Poor Pigs
 * Aug 2022 Day 6
 * Top 100% (0ms)
 * 
 * Combination math problem I couldn't get on my own.
 * This explanation makes the most sense: https://leetcode.com/problems/poor-pigs/discuss/94317/Three-steps-thinking-process-for-poor-pigs
 *
 * Quick summary:
 * T(n,k) = max buckets that can be tested to find a poisonous bucket with n pigs and k test iterations
 * T(1, 1) = 2 
 *      If our pig dies we found the poisonous bucket, otherwise its the 
 * T(1, k) = k + 1 
 *      Since only one bucket is poisonous, if our pig dies we found the poisonous bucket, otherwise it will 
 *      always be the last bucket
 * T(n, k) = (k + 1) ^ n is the general solution (rewriting it in terms of n is the solution)
 *      With n pigs, there are (k+1)^n combinations for the pigs to drink buckets
 *          Note that two pigs can drink from the same bucket in one test
 *      e.g. with 4 buckets, and one test iteration, 2 pigs can solve the problem
 *          Bucket:          0         1        2      3    
 *          Pigs(A and B)    None      A        B      AB
 *              If A dies its 1
 *              If B dies its 2
 *              If A and B die its 3
 *              If none die its 0
 *                  (1+1)^2 = 4, the general solution holds
 * 
 *      The easiest way to go about this probelm is to write out examples for 1 an 2 tests and try out the pattern
 *          Read this for more: https://leetcode.com/problems/poor-pigs/discuss/94273/solution-with-detailed-explanation
 * 
 * Time complexity: O(1)
 */


class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = (int)Math.floor(minutesToTest/minutesToDie);
        return (int)Math.ceil((Math.log(buckets) / Math.log(k + 1)));
    }
}

/*
T(n, k) 
n = number of pigs
k = number of tests
T(n, k) = maximum number of buckets that can be proven to not have poison in them
with n pigs and k test iterations

T(1, 1) = 2 (if our pig dies we found the poisonous bucket, otherwise its the non tested bucket)
T(1, k) = k + 1 (only one bucket is poisonous, if our pig drinks it we win, otherwise it will 
always be the last non-tested bucket)
T(n, k) = (k + 1) ^ n (if we have n pigs, the total number of combinations in having the pigs try
the water
*/