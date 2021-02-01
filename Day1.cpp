#include <vector>

class Day1 {
public:
    bool canFormArray(std::vector<int>& arr, std::vector<std::vector<int>>& pieces) {
        for (int i = 0; i < pieces.size(); i++) {
            bool pieceFit = false;
            for (int j = 0; j < arr.size(); j++) {
                if (arr[j] == pieces[i][0]) {
                    for (int k = 0; k < pieces[i].size(); k++) {
                        if (j + k >= arr.size() || arr[j + k] != pieces[i][k]) {
                            return false;
                        }    
                        else if (k == pieces[i].size() - 1) {
                            pieceFit = true;
                        }
                        
                    }   
                }
                if (pieceFit == true) {
                    break;
                }
                else if (pieceFit == false && j == arr.size() - 1) {
                    return false;
                }
            }
        }
    
        return true;
    }
};