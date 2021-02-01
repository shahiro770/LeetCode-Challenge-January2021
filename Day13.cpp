#include <algorithm>
#include <vector>

class Day13 {
public:
    int numRescueBoats(std::vector<int>& people, int limit) {
        std::sort(people.begin(), people.end());
        int left = 0;
        int right = people.size() - 1;
        int boats = 0;
        while (left <= right){
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                boats++;
            }
            else {
                right--;
                boats++;
            }
        }
        
        return boats;
    }
};