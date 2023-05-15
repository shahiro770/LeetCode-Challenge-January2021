/*
 * Build an Array With Stack Operations
 *
 * Top 100% (0ms)
 * 
 * Shouldn't have been a medium
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> sol = new ArrayList<String>();
        int streamNum = 1;
        int pos = 0;

        while (streamNum - 1 != target[target.length - 1]) {
            sol.add("Push");
            if (target[pos] != streamNum) {
                sol.add("Pop");
            }
            else {
                pos++;
            }
            streamNum++;
        }

        return sol;
    }
}