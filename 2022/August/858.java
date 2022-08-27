/**
 * Mirror Reflection
 * Aug 2022 Day 4
 * 
 * Top 100% (0ms) 
 * 
 * Question is dumb maths: https://leetcode.com/problems/mirror-reflection/discuss/2377070/Pseudocode-Explain-Why-Odd-and-Even-Matter
 * Time Complexity: O(log(max(p,q)))
 **/

class Solution {
    public int mirrorReflection(int p, int q) {
        int m = p;
        int n = q;
        
        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2;
            n /= 2;
        }
        
        if (m % 2 == 0 && n % 2 == 1) {
            return 2;
        }
        else if (m % 2 == 1 && n % 2 == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }
}