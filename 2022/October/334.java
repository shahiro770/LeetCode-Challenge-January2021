/**
 * Increasing Triplet Subsequence
 * 
 * Top 99% (2ms)
 * 
 * The idea (call this (I)) :
 * Say you had two variables that are arbitrarily large to start, "first" and "second"
 *  1) Find a number (i.e. we loop through nums) that is less than first, set first equal to that.
 *  2) If you find another number that is greater than first but less than second, set second equal to that.
 *  3) Any number that fails both conditions in order must be greater than both in an increasing order (i.e. thats a triplet).
 * 
 * The above logic is easy to follow, but there's a catch with how it updates.
 * Look at the example: [20, 100, 10, 12, 5, 13]
 *  1) After i = 1, we will have first = 20, second = 100
 *      That means we know if we encounter a number > 100, we have a solved triplet
 *  2) On i = 2, first gets overidden to 10, which is fine since the logic from 1) still holds 
 *      Second is still 100, and by the structure of (I) we can still hit the 3rd condition
 *  3) On i = 3, second gets overriden to 12, is this a problem?
 *      Second as an idea represents "there is a number before me that is less than me"
 *      This means we know the minimum value required to form a triplet must be > second
 *      i.e. our boundary >100 has been reduced to >12
 *  4) On i = 4 first = 5, but we still maintain our triple lower bound of > 12
 *  5) i = 5 gives us 13 which is greater than second, proving we have an increasing triplet
 * 
 * 
 * Time complexity: O(n)
 */


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            }
            else if (nums[i] <= second) {
                second = nums[i];
            }
            else {
                return true;
            }
        }

        return false;
    }
}