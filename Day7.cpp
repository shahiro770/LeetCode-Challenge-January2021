#include <algorithm>
#include <string>

class Day7 {
public:
    int lengthOfLongestSubstring(std::string s) {
        int largest = 0;
        int lastIndex[1000] = { };
        std::fill(lastIndex, lastIndex + 1000, -1);
        int startingIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            startingIndex = std::max(startingIndex, lastIndex[s[i]] + 1);
            
            largest = std::max(largest, i - startingIndex + 1);
            
            lastIndex[s[i]] = i;
        }
        
        return largest;
    }
};