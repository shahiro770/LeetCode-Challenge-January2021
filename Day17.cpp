/***
 * This question is stupid.
 * The real solution is an o(1) that calculates the nth pentalope number (pentalope = 5th number in any row of pascal's triangle)
 * I have no idea why the nth pentalope number = the # of lexographically sorted vowel strings of length n (besides 5 vowels = penta).
*/

class Day17 {
public:
    int countVowelStrings(int n) {
        return countVowelStrings(n, 0);
    }
    
    int countVowelStrings(int n, int lastCharacter) {
        int count = 0;
        if (n == 0){
            return 1;
        }
        for (int i = 0; i < 5; i++) {
            if (i >= lastCharacter) {
                count += countVowelStrings(n - 1, i);
            }
        }
        
        return count;
    }
};
