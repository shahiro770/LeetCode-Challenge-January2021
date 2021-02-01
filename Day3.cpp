#include <algorithm>    
#include <vector>       

class Day3 {
public:
    int countArrangement(int n) {
        int arrangements = 0;
        std::vector<int> nums;
        
        for (int i = 1; i <= n; i++) {
            nums.push_back(i);
        }
        arrangements += countArrangement(0, nums);
        
        return arrangements;
    }
    
    int countArrangement(int index, std::vector<int>& nums) {
        if (index == nums.size()) {
            return 1;
        }
        else {
            int arrangements = 0;
            for (int i = index; i < nums.size(); i++) {
                if (nums[i] % (index + 1) == 0 || (index + 1) % nums[i] == 0) {
                    std::swap(nums[i], nums[index]);
                    arrangements += countArrangement(index + 1, nums);
                    std::swap(nums[i], nums[index]);
                }
            }
            return arrangements;
        }
    }
};