class Day21 {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] mostComp = new int[k];
        int compIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // add the first number
            if (compIndex == 0) {   
                mostComp[compIndex] = nums[i];
                compIndex++;
            }
            else {
                // if current number is smaller than the leading competitive number, see how far back
                // we can go (can't go too far back if there aren't k numbers left)
                if (mostComp[compIndex - 1] > nums[i] && k - compIndex < nums.length - i) {
                    int indicesBack = compIndex - 1;
                    while (indicesBack >= 0) {
                        if (mostComp[indicesBack] > nums[i] && k - indicesBack <= nums.length - i) {
                            indicesBack--;
                        }
                        else{
                            break;
                        }
                    }
                    compIndex = indicesBack + 1;
                    mostComp[compIndex] = nums[i];
                    compIndex++;
                }
                else if (compIndex < k) {   // add new number if its not competitive enough to beat earlier entries
                    mostComp[compIndex] = nums[i]; 
                    compIndex++;
                }
            }
        }
        
        return mostComp;
    }
}