/**
 * Find the Duplicate Number
 * 
 * Top 90% (5ms)
 * 
 * Very tricky question if you don't know floyd's cycle detection algorithm 
 * (tortoise and hare).
 * There's two parts:
 *   1) Find where the cycle is (see 141 for floyd's algo explanation)
 *   2) Have a second slow pointer that moves up at the same time as the slow pointer
 *      that had been used to determine there was a cycle in nums. Where these two slow pointers meet
 *      is where the duplicate number will be
 * 
 * Quick explanations on why this works:
 *   0) Due to the constraint that the array contains [1,n], each node must point to another 
 *      (which leads to the cycle) except for index 0
 *   0.1) e.g. [1,3,4,2,2]
 *      0 -> 1 -> 3 -> 2 -> 4 -> 2 -> 4 -> 2...
 *   0.2) For the algorithm's design, we can start at index 0 assuming its not part of the cycle
 *   1) The fast pointer will be closing the gap between it and the slow pointer as it moves twices as fast
 *      If there is a cycle, they are eventually going to meet as a result of the math
 *   1.1) e.g. if the distance between the pointers was 10, the slow increases the gap by one 
 *      while the fast decreases the gap by 2, eventually becoming 0)
 *   2) Due to math, the position between the cycle is confirmed by floyd's algo and the starting
 *      position (0) will both be the same distance from the node that is represented by the duplicate value
 *   2.1) Very simplified example, but suppose:
 * 
 *      P = distance from 0 to duplicate node D
 *      X = distance from cycle confirmation spot S to duplicate node D
 *      C = cycle's length
 * 
 *      Then suppose the cycle is detected at S and that the fast pointer has done 2 full walks of all
 *      the nodes in the cycle. It could potentially do more depending on the distance from the start 
 *      to the cycle, but again lets keep it simple. W
 *          
 *      Now we could say fast has traveled all of P, and twice the cycle's length minus X
 *      as it stops X unites away from a full second traversal.
 *      We could also say, slow has traveled all of P, and C - X for similar reasons.
 * 
 *      fast = P + 2C - X
 *      slow = P + C - X
 * 
 *      Given that fast is traveling at twice the speed as slow, we have the equivalence
 * 
 *      fast = 2 * slow
 *      P + 2C - X = 2(P + C - X)
 *      P + 2C - X = 2P + 2C - 2X
 *      P = X                           // collect like terms
 *      
 *      And thats why the distances are the same, so when they meetwe will have the duplicate number
 *          
 * Time complexity: O(n)
 * 
 * */

class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        boolean first = true;
        while (first == true || fast != slow) {
            if (first == true) {
                first = false;
            }
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) {
                break;
            }
        }

        int slow2 = nums[0];
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow;
    }
}