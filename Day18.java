/**
 * Literally garbage tier solution (like 10% in speed and 50% in memory surprisingly)
 * My gut feeling was to sort the array and then compare from left and right but then I was like
 * "yeah but sorting the array takes too long" (spoilers I was wrong)
 * Question is easy enough to do silly things like this though.
 */

import java.util.*;

class Day {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hashNums = new HashMap<>();
        int ops = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hashNums.get(k - nums[i]) == null && hashNums.get(nums[i]) == null) { 
                hashNums.put(k - nums[i], 0);
                hashNums.put(nums[i], 1);
            }
            else if (hashNums.get(k - nums[i]) == null) {
                 hashNums.put(k - nums[i], 0);
            }
            else if (hashNums.get(nums[i]) == null) {
                hashNums.put(nums[i], 1);
            }
            else if (hashNums.get(k - nums[i]) == 0 && hashNums.get(nums[i]) >= 0) { 
                hashNums.put(nums[i], hashNums.get(nums[i]) + 1);
            }
            else {
                hashNums.put(k - nums[i], hashNums.get(k - nums[i]) - 1);
                ops++;
            }
        }
        
        return ops;
    }
}