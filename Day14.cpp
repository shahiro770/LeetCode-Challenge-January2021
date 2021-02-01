#include <vector>

class Day14 {
public:
    int minOperations(std::vector<int>& nums, int x) {
        int operations = nums.size();
        int sum = 0;
        int arraySum = 0;
        int startIndex = 0;
        int endIndex = 0;
        bool isSolution = false;
        
        for (int i = 0 ; i < nums.size(); i++) {
            arraySum += nums[i];
        }
        if (arraySum == x) {    //edge case that the x = sum of array, then all operations are required
            return operations;
        }
        
        for (int i = 0 ; i < nums.size(); i++) {
            endIndex = i;
            if (sum + nums[i] <= arraySum - x) {
                sum += nums[i];
        
                int numOperations = nums.size() - (endIndex - startIndex);  
                if (sum == (arraySum - x) && numOperations <= operations) {
                    operations = nums.size() - ((endIndex + 1) - startIndex);   
                    isSolution = true;
                }
            }
            else {
                while (sum + nums[i] > arraySum - x && startIndex < endIndex) {
                    sum -= nums[startIndex];
                    startIndex++;
                }

                if (sum + nums[i] <= arraySum - x) {
                    sum += nums[i];
                    int numOperations = nums.size() - (endIndex - startIndex);
                    if (sum == (arraySum - x) && numOperations <= operations) {
                        operations = nums.size() - ((endIndex + 1) - startIndex);
                        isSolution = true;
                    }
                }
                if (startIndex == endIndex) {
                    startIndex++;
                }
            }
        }
 
        if (isSolution == false) {
            return -1;
        }
        if (operations == 0) {  // if startIndex = endIndex, math becomes jank so return 1
            operations = 1;
        }
        return operations;
    }
};