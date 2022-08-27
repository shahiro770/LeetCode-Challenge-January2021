/*
 * Hate this question so god damn much took like 5 hours. The BFS idea is simple, but leetcode wants to
 * end your life over optimization; doing it bidirectionally, putting it all in a graph
 * so all adjacents are "preprocessed", optimizing adjacency checks by assuming its all letters a-z or 
 * caring about intermediaries using jank "*" solutions.
 * But none of that matters compared to the efficiency you get by SWAPPING THE WORDLIST VECTOR TO A SET. 
 * Don't even care to improve this solution leetcode is garbage for making the timing so tight.
*/ 

#include <string>
#include <set>
#include <vector>
#include <queue>

class Day9 {
public:
    int ladderLength(std::string beginWord, std::string endWord, std::vector<std::string>& wordList2) {
        int length = 1;
        int wordsThisLevel = 0;
        int wordsNextLevel = 0;
        
        std::queue<std::string> wordQueue;
        std::set<std::string> wordList;
        
        bool possible = false;
        for (int i = 0; i < wordList2.size(); i++) {
            wordList.insert(wordList2[i]);
            if (wordList2[i] == endWord) {
                possible = true;
            }
        }
        if (possible == false) {
            return 0;
        }
        
        wordQueue.push(beginWord);
        wordsNextLevel = 1;
        
        while (wordQueue.empty() == false) {
            length++;
            wordsThisLevel = wordsNextLevel;
            wordsNextLevel = 0;
            while (wordsThisLevel > 0) {
                wordsThisLevel--;
                std::string word = wordQueue.front();
                wordQueue.pop();
                
                for (int i = 0; i < word.length(); i++) {
                    char originalChar = word[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        word[i] = c;
                        if (wordList.find(word) != wordList.end()) {  
                            wordsNextLevel++;
                            wordQueue.push(word);
                            if (word == endWord) {
                                return length;
                            }
                            wordList.erase(*wordList.find(word));
                        }
                    }
                    word[i] = originalChar;
                }
            }
        }
        
        return 0;
    }
};

any merchants regularly charging
    aka amazon prime
    uber eats
    online statements 