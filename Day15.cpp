#include <vector>

class Day15 {
public:
    int getMaximumGenerated(int n2) {
        std::vector<int> nums;
        
        int n = n2 + 1;
        nums.push_back(0);
        int max = 0;
        if (n >= 2) {
            nums.push_back(1);
            max = 1;
        }
        
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0) {
                nums.push_back(nums[i / 2]);
            }
            else {
                nums.push_back(nums[i / 2] + nums[(i / 2) + 1]);
            }
            if (nums[i] > max) {
                max  = nums[i];
            }
        }
        
        return max;
    }
};