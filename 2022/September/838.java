/*
 * Push Dominoes
 * 
 * September 2022
 * Top 91% (18ms)
 * 
 * Use a left and right pointer and cover all the cases. Its a mess of a question
 * 
 * Time complexity: O(n)
 * 
 * */

class Solution {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int left = 0;
        int right = 0;
        int end = dominoes.length();
        
        for (right = 0; right < end; right++) {
            // Move right up one on dot
            if (d[right] == '.') {
                // except in the event we reach the end, and left is R and we end in a dot
                // then the rest are all R (e.g. [R..] -> [RRR])
                if (d[left] == 'R' && right == end - 1) { 
                    for (int i = left; i <= right; i++) {
                        d[i] = 'R';
                    }
                    left = right;
                }
            }
            // [L..R] -> [L..R]
            else if (d[left] == 'L' && d[right] == 'R') {
                left = right;
            }
            // [L..L] -> [LLLL], [R..R] -> [RRRR], [...L] -> [LLLL]
            else if (d[left] == d[right] || (d[left] == '.' && d[right] == 'L')) {
                for (int i = left; i <= right; i++) {
                    d[i] = d[right];
                }
                left = right;
            }
            // [R...L] -> [RR.LL], [R..L] -> [RRLL]
            else if (d[left] == 'R' && d[right] == 'L') {
                int diff = right - left - 1;
                if (diff % 2 == 0) {
                    for (int i = 0; i <= diff / 2; i++) {
                        d[left + i] = 'R';
                    }
                    for (int i = 0; i <= diff / 2; i++) {
                        d[right - i] = 'L';
                    }
                }
                else {
                    // System.out.println("WE HERE");
                    for (int i = 0; i <= diff / 2; i++) {
                        d[left + i] = 'R';
                    }
                    for (int i = 0; i <= diff / 2; i++) {
                        d[right - i] = 'L';
                    }
                }
                left = right;
            }
            // any other case just make sure left and right are equal (e.g.[..R], left and right should be equal)
            else {
                left = right;
            }
        }
                
        return new String(d);
    }
}

/*
".L.R...LR..L.."
"RR.L"
".L.R...LR..L.."
"L...R"
"R...L"
"R"
"L"
"."
".L.R."
*/