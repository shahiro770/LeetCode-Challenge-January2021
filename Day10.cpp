#include <algorithm>
#include <vector>
#include <cmath>

class Day10 {
public:
    int createSortedArray(std::vector<int>& instructions) {
        int cost = 0;
        std::vector<int> nums;
        
        for (int i = 0; i < instructions.size(); i++) {
            int low = 0;
            int high = nums.size() - 1;
            int index = 0;
            
            int low3 = 0;
            int high3 = nums.size() - 1;
            int index3 = 0;

            while (low <= high) {    
                index = std::floor((low + high) / 2);
                if (nums[index] <= instructions[i]) {
                    low = index + 1;
                }
                else if (nums[index] > instructions[i]){
                    high = index - 1;
                }
                
                else {
                    low = index;
                    break;
                }
            }
            
            while (low3 <= high3) {    
                index3 = std::floor((low3 + high3) / 2);
                if (nums[index3] < instructions[i]) {
                    low3 = index3 + 1;
                }
                else if (nums[index3] >= instructions[i]){
                    high3 = index3 - 1;
                }
                
                else {
                    low3 = index3;
                    break;
                }
            }

            auto it = nums.begin();

            nums.insert(it + low, instructions[i]);
            
            int numDuplicate = low - low3;
            int numLesser = low - numDuplicate;
            int numGreater = nums.size() - low - 1;
            cost += std::min(numLesser, numGreater);
        }
        
        return cost % 1000000007;
    }
};