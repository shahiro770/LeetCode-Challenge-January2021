#include <vector>
#include <string>

class Day8 {
public:
    bool arrayStringsAreEqual(std::vector<std::string>& word1, std::vector<std::string>& word2) {
        std::string word1f;
        std::string word2f;
        for (int i = 0; i < word1.size(); i++) {
            word1f += word1[i];
        }
        for (int i = 0; i < word2.size(); i++) {
            word2f += word2[i];
        }
        
        return word1f == word2f;
    }
};