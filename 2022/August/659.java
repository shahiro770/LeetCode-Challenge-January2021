/*
 * Split Array into Consecutive Subsequences
 *
 * August 2022
 * Top 71% (26ms)
 *
 * The dumb way of manually making lists and seeing which ones you can append to
 * will time you out. There's a super smart way to do this problem in O(1) space complexity
 * (https://tinyurl.com/3ck6huu6) This solution is in the middle.
 *
 * First get the frequencies of each number (use a hashmap).
 * From there you count through the numbers and have four cases for the current number n:
 * 
 * 1) n has a frequency of 0. That means all n's have been used up in existing subsequences
 * 
 * 2) n, n + 1, and n + 2 have frequencies greater than 0 (aka they are available), 
 * decrease all of their frequencies by 1 "forming" a subsequence.
 * The consequence of this is that we now know if we ever needed to, we could append n + 3 to this subsequence.
 * So make a seperate "needed" frequency hashmap of the numbers we could use for existing subsequences
 * 
 * 3) n is already in our "needed" frequencies with a frequency greater than 0. We can just subtract
 * from this map and update n + 1 as a needed frequency in this map
 * 
 * 4) Neither case 2 or 3, this means it is impossible to fit this number into an existing subsequence
 * or make a new one with the number. Return false;
 * 
 * Note that due to the "greedy" nature of this solution, it is always optimal to see if we can add the number to 
 * an existing subsequence first before trying to form a new one. Take a look at [1,2,3,4,5,5,6,7]:
 * 
 * If we tried to prioritize making new lists first, we'd get:
 * [1,2,3]
 * [4,5,6]
 * ...and an extra 5 and 7 with no where to go. 
 * 
 * However, if we tried to add on 4 and 5 first:
 * [1,2,3,4,5]
 * [5,6,7]
 * 
 * I think the reason why greed works in this case is because the input is sorted and
 * you're always left with more options with how to form a list if you only consume 1 number
 * by appending it to an existing list.
 * If you skip over a number (e,g, skip a 5 in this case when using a 4,5,6), don't get 
 * the full lookahead for the skipped number (i.e. would 5,6,7 have been a sequence?).
 * 
 * Time complexity: O(n)
*/


class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> need = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (freq.getOrDefault(nums[i], 0) > 0) {
                // concatenate
                if (need.getOrDefault(nums[i], 0) > 0) {
                    need.put(nums[i], need.get(nums[i]) - 1);
                    freq.put(nums[i], freq.get(nums[i]) - 1);
                    need.put(nums[i] + 1, need.getOrDefault(nums[i] + 1, 0) + 1);   
                }
                // create a new list
                else if (freq.getOrDefault(nums[i] + 1, 0) > 0 && freq.getOrDefault(nums[i] + 2, 0) > 0) {
                    freq.put(nums[i], freq.get(nums[i]) - 1);
                    freq.put(nums[i] + 1, freq.get(nums[i] + 1) - 1);
                    freq.put(nums[i] + 2, freq.get(nums[i] + 2) - 1);

                    need.put(nums[i] + 3, need.getOrDefault(nums[i] + 3, 0) + 1);
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
}