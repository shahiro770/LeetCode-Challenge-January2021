#include <vector>

class Day11 {
public:
    void merge(std::vector<int>& nums1, int m, std::vector<int>& nums2, int n) {
        int nums1Index = 0;
        int nums2Index = 0;
        int numToPop = 0;

        while (nums1Index < n + m && nums2Index < n) {
            if (nums1[nums1Index] >= nums2[nums2Index]) {
                nums1.insert(nums1.begin() + nums1Index, nums2[nums2Index]);
                numToPop++;
                nums2Index++;
                nums1Index++;
            }   
            else if (nums1Index >= m + numToPop) {
                nums1[nums1Index] = nums2[nums2Index];
                nums1Index++;
                nums2Index++;
            }
            else {
                nums1Index++;
            }
        }
        
        for (int i = 0; i < numToPop; i++) {
            nums1.pop_back();
        }
    }
};