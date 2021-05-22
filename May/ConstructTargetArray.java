/**
 * May 2021 Day 9
 * 
 * Beats 89.97% cause leetcode hard questions are jank
 * 
 * Really weird optimizations needed here but the gist of the problem
 *      1) You need to try and "reverse" the passed in array back to its state of all 1's  (or show its impossible)
 *          The value of the largest value in the array will always be equal to the sum of all values in the array + what it was originally
 *              That is, originalValue = currentValue - (sum - currentValue)
 *          Obviously this can only work on the largest value, which is why a priorityQueue helps here
 *      2) Upon doing this undo, you can observe there are 4 edge cases (woah)
 *          2.1) If the original value is 0 or equal to the sum its not possible
 *              Look at the array of [2], originalValue = currentValue - (sum - currentValue)
 *                   => ? = 2 - 2 - 2 = 2, we can't get [1] as we're stuck in a loop
 *          2.2) If the original value is negative its also not possible
 *              Take [1, 2, 2], originalValue = currentValue - (sum - currentValue)
 *                  => ? = 2 - (5 - 2) =  -1, we can't get [1, 1, 1]
 *          2.3) If the sum after reversing the max value is less than 1 we also got an impossible
 *      3) Make use of % to optimize, since it saves iterations on reversing a number
 *          [13, 5] -> [8, 5] -> [3, 5]
 *              Just go 13 % 5 at the start and you save a whole iteration
 *              
 * Time compleixty: O(nlogn)
 */

class Solution {
    public boolean isPossible(int[] target) {
        int sum = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a); 
        
        for (int i = 0; i < target.length; i++) {
            pq.offer(target[i]);
            sum += target[i];
        }
        
        while (pq.peek() != 1) {
            int oldMax = pq.poll();
            sum -= oldMax;
            
            if (oldMax <= sum || sum < 1) {
                return false;
            }
            
            // diff = sum - oldMax
            // newNum = oldMax % diff
            // newNum = oldMax % (sum - oldMax)
            int newNum = oldMax % sum;
            sum += newNum;
            if (sum != 1 && newNum <= 0) {  // idk what i did here it just worked
                return false;
            }
            pq.offer(newNum);
        }
        
        return true;
    }
}