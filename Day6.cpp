#include <vector>

class Day6 {
public:
    int findKthPositive(std::vector<int>& arr, int k) {
        std::vector<int> missingNums;
        int arrIndex = 0;
        if (arr.size() == 0) {
            return k;
        }
        for (int i = 1; i < arr[arr.size() - 1]; i++) {
            if (arr[arrIndex] != i) {
                missingNums.push_back(i);
            }
            else {
                arrIndex++;
            }
        }
        
        if (missingNums.size() < k) {
            return arr[arr.size() - 1] + (k - missingNums.size());
        }
        return missingNums[k - 1];
    }
};