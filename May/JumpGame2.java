/**
 * May 2021 Day 5
 * 
 * Use a greedy approach for this one. Examine all of the potential indices we can jump to.
 * Move to the index that gives us the most "jump potential", which is the furthest distance travelled
 * plus the distance we can travel from that square.
 * 
 * There's a bit of weird edge case logic with "1"'s cause indices are weird.
 * 
 * Time Complexity O(n)
 */

public class JumpGame2 {
    public int jump(int[] nums) {
        int index = 0;
        int jumps = 0;
        
        while (index < nums.length - 1) {
            if (nums[index] == 1) {
                jumps++;
                index++;
            }
            else {
                int maxIndex = 0;
                int maxJumpPotential = -1;
                
                for (int j = index + 1; j < nums[index] + index + 1; j++) {
                    if (j == nums.length - 1) {
                        maxIndex = j;
                        break;
                    }
                    else if ((j + nums[j] >= maxJumpPotential) || maxJumpPotential == -1) {
                        maxIndex = j;
                        maxJumpPotential = j + nums[j];
                    }
                }
                
                jumps++;
                index = maxIndex;
            }
        }
        
        return jumps;
    }
}
