#include <algorithm>
#include <vector>

// This may be top 99% solution, but if an employer tells you you can't sort it with a builtin,
// you'll have to use the quick select algorithm (which is just quicksort but keep half)

class Day16 {
public:
    int findKthLargest(std::vector<int>& nums, int k) {
        std::sort(nums.begin(), nums.end());
        return nums[nums.size() - k];
    }
};