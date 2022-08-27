/* top 100% speed */

class Day25 {
    public boolean kLengthApart(int[] nums, int k) {
        int last1Spot = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (last1Spot == -1) {
                    last1Spot = i;
                }
                else if (i - last1Spot - 1 >= k) {
                    last1Spot = i;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
}