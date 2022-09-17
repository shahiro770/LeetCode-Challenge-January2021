/**
 * The Number of Weak Characters in the Game
 * 
 * September 2022
 * Top 88% (120ms)  
 * 
 * Sort the properties first in order of descending attack. If there's a tie with attack, 
 * sort them by defense ascendingly. Track the highest defense and increase the weakCharacter count whenever we see something with less
 * than the highest defense. Why?
 * 
 * At the front of the array will be all the highest attack values. Suppose there's a group of ties for the highest.
 * We know for a fact any characters that come after this group will have lower attack. 
 * If we sort this group with defense ascending, we can go over the values in a single loop, grabbing the highest defense
 * without saying the ones that came before were strictly weaker.
 * 
 * For example, if we had the array
 * [[10, 1], [10, 3], [10, 7]]
 * We can determine the max defense is 7 by just checking the defense property. 
 * 
 * The second we see a defense value less than the current highest, we know the current character must have a lower attack value 
 * since it would've otherwise appeared before the current highest  
 * (due to (1.1) ascending defense sorting if there were a tie and (1.2) sorting by descending attack)
 * 
 * If we somehow see a higher defense value despite there being a lower attack
 * e.g. [[10, 1], [10, 3], [10, 7], [9, 6], [9, 12]]
 * we still correctly determine any weak characters before it thanks to the ascending defense sorting
 * and can now use this new highest defense to evaluate the weak-ness of any characters that come after.
 * 
 * Time complexity: O(nlogn)
 **/

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int weakCount = 0;
        int maxDef = 0;
        Deque<int[]> charStack = new ArrayDeque<int[]>();
        
         Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
        
        for (int i = 0; i < properties.length; i++) {
            if (properties[i][1] < maxDef) {
                weakCount++;
            }
            if (maxDef < properties[i][1]) {
                maxDef = properties[i][1];
            }
        }
        
        return weakCount;
    }
}
/*
[[5,5],[6,3],[3,6]]
[[2,2],[3,3]]
[[1,5],[10,4],[4,3]]
[[1,5],[10,4],[4,3],[2,6],[11,1]]
*/